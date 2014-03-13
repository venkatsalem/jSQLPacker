package org.jsqlpacker.parser.api;

import java.util.Collection;

/**
 * Common API to parse SQL file into separate statement to execute using JDBC
 * driver
 * 
 * @author venkatsalem@gmail.com
 */
public interface SQLParser {

	/**
	 * Parse the given SQL script and return as separate statements
	 * 
	 * @param sqlFileContent
	 * @return
	 */
	public Collection<String> parser(String sqlFileContent)
			throws SQLParseException;
}
