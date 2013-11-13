package edu.cmu.lti.deiis.hw5.runner;


/**
 * Main Class that runs a Collection Processing Engine (CPE). This class reads a
 * CPE Descriptor as a command-line argument and instantiates the CPE. It also
 * registers a callback listener with the CPE, which will print progress and
 * statistics to System.out.
 * 
 * 
 */
public class AnswerRankingRunner extends CPERunner {

	/**
	 * Constructor for the class.
	 * 
	 * @param args
	 *            command line arguments into the program - see class
	 *            description
	 */
	public AnswerRankingRunner() throws Exception {
	  super("src/main/resources/AnswerRankingDescriptor.xml");
	}

	/**
	 * main class.
	 * 
	 * @param args
	 *            Command line arguments - see class description
	 */
	public static void main(String[] args) throws Exception {
		new AnswerRankingRunner();
	}
}
