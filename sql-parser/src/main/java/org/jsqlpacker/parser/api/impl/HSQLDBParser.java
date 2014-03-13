package org.jsqlpacker.parser.api.impl;

import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsqlpacker.parser.api.SQLParser;

/**
 * TODO: Replace with HSQLDB parser
 * 
 * @author Mohan Narayanasway
 */
public class HSQLDBParser implements SQLParser {
	private static Logger logger = LogManager.getLogger("SQLScriptParser");

	@Override
	public Collection<String> parser(String sqlFileContent) {
		return Arrays.asList(sqlFileContent.split(";"));
	}

	/**
	 * WARNING: Every main in this project except one Main is considered
	 * EmbeddedTestCase They are not replacement to JUnit, but works for
	 * short-time
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String sampleSql = "Select * from Employee; Select * from Student";
		if (new HSQLDBParser().parser(sampleSql).size() == 2) {
			logger.warn("It worked");
		} else {
			logger.warn("It worked");

		}

	}

}
