package org.jsqlpacker.parser.impl;

import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsqlpacker.parser.SQLParser;

/**
 * Class parses the SQL Script and converts to XML
 * 
 * @author Mohan Narayanasway
 */
public class SimpleSQLScriptParser implements SQLParser {
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
		if (new SimpleSQLScriptParser().parser(sampleSql).size() == 2) {
			logger.warn("It worked");
		} else {
			logger.warn("It worked");

		}

	}

}
