package edu.cmu.lti.util.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.jcas.cas.StringList;
import org.uimafit.util.FSCollectionFactory;

import com.google.common.collect.ArrayListMultimap;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

import edu.cmu.lti.qa4mre.type.DbpediaAnnotation;

public class DbpediaService {
	// there are programmatic methods, but are quite terrible
	// http://tmarkus.wordpress.com/2010/04/01/creating-sparql-queries-programmatically-in-java/

	static Map<String, ArrayListMultimap<String, String>> abstractCache = new HashMap<String, ArrayListMultimap<String, String>>();
	static Map<String, ArrayListMultimap<String, String>> locationCache = new HashMap<String, ArrayListMultimap<String, String>>();

	public static ArrayListMultimap<String, String> queryDbpediaEnglishAbstract(String resourceUri) {

		ArrayListMultimap<String, String> results;
		if (abstractCache.containsKey(resourceUri)) {
			results = abstractCache.get(resourceUri);
		} else {
			String englishAbstractQuery = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
					+ "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n"
					+ "PREFIX : <http://dbpedia.org/resource/>\n" + "PREFIX dbprop: <http://dbpedia.org/property/>\n"
					+ "PREFIX dbpedia: <http://dbpedia.org/>\n" + "PREFIX dbo: <http://dbpedia.org/ontology/>\n"
					+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" + "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n"
					+ " SELECT DISTINCT ?abstract FROM <http://dbpedia.org> WHERE { \n" + "{<" + resourceUri + "> dbo:abstract ?abstract\n"
					+ "FILTER (langMatches(lang(?abstract),'en'))\n" + "}\n" + "} LIMIT 1000";

			results = queryDBpediaSparsql(resourceUri, englishAbstractQuery);
			abstractCache.put(resourceUri, results);
		}

		return results;
	}

	public static ArrayListMultimap<String, String> queryDbpediaLocation(String resourceUri) {
		String generalQuery = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n"
				+ "PREFIX : <http://dbpedia.org/resource/>\n"
				+ "PREFIX dbprop: <http://dbpedia.org/property/>\n"
				+ "PREFIX dbpedia: <http://dbpedia.org/>\n"
				+ "PREFIX dbo: <http://dbpedia.org/ontology/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
				+ "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n"
				+ " SELECT DISTINCT ?country ?country_of ?place_of ?partOf ?partOf_of ?locatedIn_of ?location ?long ?lat ?name ?dbName FROM <http://dbpedia.org> WHERE { \n"
				+ "{ :"
				+ resourceUri
				+ " dbo:country ?country "
				+ "\n} UNION {"
				+ " ?country_of dbo:country :"
				+ resourceUri
				+ "\n} UNION { :"
				+ resourceUri
				+ " dbo:location ?location"
				+ "\n} UNION {"
				+ " ?place_of dbo:place :"
				+ resourceUri
				+ "\n} UNION { :"
				+ resourceUri
				+ " ?partOf dbo:isPartOf "
				+ "\n} UNION {"
				+ " ?partOf_of dbo:isPartOf :"
				+ resourceUri
				+ "\n} UNION { :"
				+ resourceUri
				+ " dbo:locatedInArea ?locatedIn"
				+ "\n} UNION { :"
				+ resourceUri
				+ " geo:long ?long . "
				+ ":"
				+ resourceUri
				+ " geo:lat ?lat\n"
				+ "} UNION { :"
				+ resourceUri
				+ " foaf:name ?name\n"
				+ "} UNION { :"
				+ resourceUri
				+ " dbprop:name ?dbName\n"
				+ "}\n"
				+ "} LIMIT 1000";

		ArrayListMultimap<String, String> results;
		if (locationCache.containsKey(resourceUri)) {
			results = locationCache.get(resourceUri);
		} else {
			results = queryDBpediaSparsql(resourceUri, generalQuery);
			locationCache.put(resourceUri, results);
		}

		return results;
	}

	public static ArrayListMultimap<String, String> queryDBpediaSparsql(String resourceUri, String query) {
		QueryExecution exec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", QueryFactory.create(query));

		ResultSet results = exec.execSelect();
		ArrayListMultimap<String, String> queryResults = ArrayListMultimap.create();

		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			Iterator<String> varNames = soln.varNames();
			for (; varNames.hasNext();) {
				String varName = varNames.next();
				String solution = soln.get(varName).toString();
				queryResults.put(varName, solution);
			}
		}

		return queryResults;
	}

	public static boolean isResourceType(DbpediaAnnotation anno, String targetType) {
		StringList typeSl = anno.getResourceType();
		for (String type : FSCollectionFactory.create(typeSl)) {
			if (type.equals(targetType)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] argv) {
		ArrayListMultimap<String, String> results = queryDbpediaEnglishAbstract("http://dbpedia.org/resource/Alzheimer%27s_disease");
		System.out.println(results.size());
		for (Entry<String, String> entry : results.entries()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
