package edu.cmu.lti.deiis.hw5.collectionreaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.util.general.AdhocMethods;

public class QA4MRETestDocReader extends CollectionReader_ImplBase {

	File testFiles[] = null;
	int nCurrFile = 0;
	NodeList documents = null;

	String questionMarker = "Q: ";
	String answerMarker = "A: ";

	int nCurrDoc = 0;

	@Override
	public void initialize() throws ResourceInitializationException {
		try {

			File inputDir = new File((String) getConfigParameterValue("inputDir"));
			testFiles = inputDir.listFiles(new OnlyNXML("xml"));
			System.out.println("Total files: " + testFiles.length);
			String xmlText = this.readTestFile();
			this.parseTestDocument(xmlText);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("Starting collection reader");
	}

	@Override
	public void getNext(CAS aCAS) throws IOException, CollectionException {
		StringBuffer documentTextWithQuestions = new StringBuffer();
		int annoOffset = 0;

		File currentFile = testFiles[nCurrFile];

		if (nCurrFile < testFiles.length && !(nCurrDoc < documents.getLength())) {
			nCurrDoc = 0;
			nCurrFile++;
			documents = null;
			getNext(aCAS);
		}

		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}

		if (documents == null) {
			try {
				String xmlText = readTestFile();
				this.parseTestDocument(xmlText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Element readingTestElement = (Element) documents.item(nCurrDoc);
		NodeList testDocNodeList = readingTestElement.getElementsByTagName("doc");

		String docText = testDocNodeList.item(0).getTextContent().trim();

		// do the segementer here
		docText = AdhocMethods.AdhocTextSegementer(docText);

		String testDocId = ((Element) testDocNodeList.item(0)).getAttribute("d_id");
		String fileName = currentFile.getName();

		String docId = fileName.replace(".xmi", "") + "_" + testDocId;

		TestDocument testDoc = new TestDocument(jcas, 0, docText.length());
		testDoc.setId(docId);
		testDoc.setText(docText);
		testDoc.addToIndexes();

		documentTextWithQuestions.append(docText);
		documentTextWithQuestions.append("\n");

		annoOffset += docText.length() + 1;

		ArrayList<QuestionAnswerSet> questionAnswersList = new ArrayList<QuestionAnswerSet>();
		NodeList questionNodeList = readingTestElement.getElementsByTagName("q");

		for (int i = 0; i < questionNodeList.getLength(); i++) {
			Element questionEle = (Element) questionNodeList.item(i);
			NodeList questionNode = questionEle.getElementsByTagName("q_str");
			String questionStr = questionNode.item(0).getTextContent();
			NodeList answerNodeList = questionEle.getElementsByTagName("answer");
			
			String questionType = questionEle.getAttribute("q_type");
			String multipleResponses = questionEle.getAttribute("q_multiple");
			String hasNegation = questionEle.getAttribute("q_negate");

			Question question = new Question(jcas);
			question.setText(questionStr);
			documentTextWithQuestions.append(questionMarker + questionStr);
			annoOffset += questionMarker.length();
			
			question.setQtype(questionType != null && questionType.length() > 0 ? questionType : null);
		  question.setRequestsMultipleAnswers(multipleResponses.toLowerCase().equals("yes"));
			question.setHasNegation(hasNegation.toLowerCase().equals("yes"));
			
			question.setBegin(annoOffset);
			question.setEnd(annoOffset + questionStr.length());
			question.addToIndexes();

			// one more blank make it prettier
			documentTextWithQuestions.append("\n\n");
			annoOffset += questionStr.length() + 2;

			ArrayList<Answer> answerCollection = new ArrayList<Answer>();
			for (int j = 0; j < answerNodeList.getLength(); j++) {
				Element ansEle = (Element) answerNodeList.item(j);
				String isCorrect = ansEle.getAttribute("correct");
				String answerStr = answerNodeList.item(j).getTextContent();
				Answer ans = new Answer(jcas);

				if (isCorrect != null) {
					if (isCorrect.equals("Yes")) {
						ans.setIsCorrect(true);
					} else {
						ans.setIsCorrect(false);
					}
				} else {
					ans.setIsCorrect(false);
				}
				ans.setId(String.valueOf(j));
				ans.setText(answerStr);

				documentTextWithQuestions.append(answerMarker + answerStr);
				annoOffset += answerMarker.length();
				ans.setBegin(annoOffset);
				ans.setEnd(annoOffset + answerStr.length());
				ans.addToIndexes();

				documentTextWithQuestions.append("\n");
				annoOffset += answerStr.length() + 1;
				answerCollection.add(ans);
			}
			FSList answerFSList = this.createAnswerFSList(jcas, answerCollection);
			QuestionAnswerSet questionAnswers = new QuestionAnswerSet(jcas);
			questionAnswers.setQuestion(question);
			questionAnswers.setAnswerList(answerFSList);
			questionAnswersList.add(questionAnswers);
			questionAnswers.addToIndexes();

			// one blank line make it prettier
			documentTextWithQuestions.append("\n");
			annoOffset += 1;
		}
		FSList quetionAnswersFSList = this.createQuestionAnswersFSList(jcas, questionAnswersList);

		// put document in CAS
		jcas.setDocumentText(documentTextWithQuestions.toString());
		jcas.setDocumentLanguage("en");
		testDoc.setQaList(quetionAnswersFSList);

		setSourceDocumentInformation(jcas, currentFile.toURI().toString(), (int) currentFile.length(), hasNext(), nCurrDoc);
		// nCurrFile++;
		nCurrDoc++;
	}

	public String readTestFile() throws Exception {
		// open input file list iterator
		BufferedReader bfr = null;
		String xmlText = "";
		try {
			bfr = new BufferedReader(new FileReader(testFiles[nCurrFile]));
			char chars[] = new char[4096];
			while ((bfr.read(chars)) != -1) {
				xmlText += new String(chars).trim();
				chars = null;
				chars = new char[4096];
			}
			xmlText = xmlText.trim();
			// System.out.println(xmlText);
			System.out.println("Read: " + testFiles[nCurrFile].getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bfr != null) {
				bfr.close();
				bfr = null;
			}
		}
		return xmlText;
	}

	public FSList createAnswerFSList(JCas aJCas, Collection<Answer> aCollection) {
		if (aCollection.size() == 0) {
			return new EmptyFSList(aJCas);
		}

		NonEmptyFSList head = new NonEmptyFSList(aJCas);
		NonEmptyFSList list = head;
		Iterator<Answer> i = aCollection.iterator();
		while (i.hasNext()) {
			head.setHead(i.next());
			if (i.hasNext()) {
				head.setTail(new NonEmptyFSList(aJCas));
				head = (NonEmptyFSList) head.getTail();
			} else {
				head.setTail(new EmptyFSList(aJCas));
			}
		}

		return list;
	}

	public FSList createQuestionAnswersFSList(JCas aJCas, Collection<QuestionAnswerSet> aCollection) {
		if (aCollection.size() == 0) {
			return new EmptyFSList(aJCas);
		}

		NonEmptyFSList head = new NonEmptyFSList(aJCas);
		NonEmptyFSList list = head;
		Iterator<QuestionAnswerSet> i = aCollection.iterator();
		while (i.hasNext()) {
			head.setHead(i.next());
			if (i.hasNext()) {
				head.setTail(new NonEmptyFSList(aJCas));
				head = (NonEmptyFSList) head.getTail();
			} else {
				head.setTail(new EmptyFSList(aJCas));
			}
		}

		return list;
	}

	public void parseTestDocument(String xmlText) throws Exception {

		DOMParser parser = new DOMParser();
		parser.parse(new InputSource(new StringReader(xmlText)));
		Document document = parser.getDocument();

		NodeList topicNodeList = document.getElementsByTagName("topic");

		for (int i = 0; i < topicNodeList.getLength(); i++) {

			Element topicElement = (Element) topicNodeList.item(i);
			String topicId = topicElement.getAttribute("t_id");
			NodeList readingTestNodeList = topicElement.getElementsByTagName("reading-test");

			documents = readingTestNodeList;
			// Element eleReading=(Element)readingTestNodeList;
			// String rId=eleReading.getAttribute("r_id");
		}

	}

	/**
	 * Closes the file and other resources initialized during the process
	 * 
	 */

	@Override
	public void close() throws IOException {
		System.out.println("Closing QA4MRETestDocReader");
	}

	@Override
	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(nCurrFile, testFiles.length, Progress.ENTITIES) };
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		// return nCurrFile < 10;
		// return nCurrFile < testFile.length;
		if (nCurrFile < testFiles.length && nCurrDoc < documents.getLength()) {
			// System.out.println("***********True: currFile " + nCurrFile
			// + "\tcurrDoc " + nCurrDoc);
			return true;
		}
		return false;
	}

	private class OnlyNXML implements FilenameFilter {
		String ext;

		public OnlyNXML(String ext) {
			this.ext = "." + ext;
		}

		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
	}

	private void setSourceDocumentInformation(JCas aJCas, String uri, int size, boolean isLastSegment, int offset) {
		SourceDocumentInformation srcDocInfo = new SourceDocumentInformation(aJCas);
		srcDocInfo.setUri(uri);
		srcDocInfo.setOffsetInSource(offset);
		srcDocInfo.setDocumentSize(size);
		srcDocInfo.setLastSegment(isLastSegment);
		srcDocInfo.addToIndexes();
	}
}
