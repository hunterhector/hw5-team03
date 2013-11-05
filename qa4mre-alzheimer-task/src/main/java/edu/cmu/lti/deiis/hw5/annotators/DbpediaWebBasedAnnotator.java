package edu.cmu.lti.deiis.hw5.annotators;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
//import org.uimafit.component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.util.FSCollectionFactory;
import org.uimafit.util.JCasUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.ArrayListMultimap;

import edu.cmu.lti.qa4mre.type.DbpediaAnnotation;
import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.util.services.DbpediaService;

public class DbpediaWebBasedAnnotator extends JCasAnnotator_ImplBase {
	public static final String ANNOTATOR_COMPONENT_ID = "System-dbpedia-spotlight";

	public static final String PARAM_SUPPORT = "support";

	public static final String PARAM_CONFIDENCE = "confidence";

	@ConfigurationParameter(name = PARAM_SUPPORT)
	private int support;

	@ConfigurationParameter(name = PARAM_CONFIDENCE)
	private float confidence;

	private HttpClient httpClient;

	private DocumentBuilderFactory dbFactory;

	private DocumentBuilder dBuilder;

	private String dbpediaPrefix = "http://dbpedia.org/resource/";

	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		httpClient = new DefaultHttpClient();

		dbFactory = DocumentBuilderFactory.newInstance();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// String documentText = aJCas.getDocumentText();

		for (TestDocument doc : JCasUtil.select(aJCas, TestDocument.class)) {
			annotateText(doc.getCoveredText(), aJCas, doc.getBegin());
		}

		for (Question question : JCasUtil.select(aJCas, Question.class)) {
			annotateText(question.getCoveredText(), aJCas, question.getBegin());
		}

		for (Answer answer : JCasUtil.select(aJCas, Answer.class)) {
			annotateText(answer.getCoveredText(), aJCas, answer.getBegin());
		}

		try {
			// this calls Dbpedia remotely so I let it sleep for every document
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void annotateText(String text, JCas aJCas, int textOffset) {
		HttpPost httpPost = new HttpPost("http://spotlight.dbpedia.org/rest/annotate/");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("disambiguator", "Default"));
		nvps.add(new BasicNameValuePair("confidence", Float.toString(confidence)));
		nvps.add(new BasicNameValuePair("support", Integer.toString(support)));
		nvps.add(new BasicNameValuePair("text", text));
		httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
		httpPost.addHeader("Accept", "text/xml");
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			HttpResponse response = httpClient.execute(httpPost);
			System.out.println(response.getStatusLine());

			HttpEntity entity = response.getEntity();

			Document doc = dBuilder.parse(entity.getContent());

			NodeList resources = doc.getElementsByTagName("Resource");
			int numOfResources = resources.getLength();
			System.out.println(String.format("Creating %d resources in text.", numOfResources));
			for (int i = 0; i < numOfResources; i++) {
				Node resource = resources.item(i);
				NamedNodeMap attributes = resource.getAttributes();
				String uri = attributes.getNamedItem("URI").getNodeValue();
				int offset = Integer.parseInt(attributes.getNamedItem("offset").getNodeValue()) + textOffset;
				double similarity = Double.parseDouble(attributes.getNamedItem("similarityScore").getNodeValue());
				String surface = attributes.getNamedItem("surfaceForm").getNodeValue();
				String types = attributes.getNamedItem("types").getNodeValue();

				createDbpediaResource(aJCas, uri, offset, surface, similarity, types);
			}
			System.out.println("Finish creating resources");

			EntityUtils.consume(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
	}

	private void createDbpediaResource(JCas aJCas, String uri, int begin, String surface, Double sim, String types)
			throws UnsupportedEncodingException {
		DbpediaAnnotation anno = new DbpediaAnnotation(aJCas);
		String abstractText = null;

		// actually raw encoded url is the best!
		// String resourceUri = uri.replaceAll("^" + dbpediaPrefix, "");
		// String decodedUri = URLDecoder.decode(resourceUri, "UTF-8");
		// System.out.println(resourceUri + " " + decodedUri);

		try {
			ArrayListMultimap<String, String> results = DbpediaService.queryDbpediaEnglishAbstract(uri);
			for (Entry<String, String> entry : results.entries()) {
				abstractText = entry.getValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Cannot query this uri " + uri);
		}

		int end = begin + surface.length();
		anno.setBegin(begin);
		anno.setEnd(end);
		anno.setUri(uri);
		anno.setAbstract(abstractText);
		anno.setSimilarityScore(sim);
		List<String> allTypes = Arrays.asList(types.split(","));
		anno.setComponentId(ANNOTATOR_COMPONENT_ID);
		anno.setResourceType(FSCollectionFactory.createStringList(aJCas, allTypes));
		anno.addToIndexes();
	}

}
