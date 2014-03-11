package org.jsqlpacker.parser;

import java.util.Collection;

/**
 * Packages given SQL Scripts as a tool to run by DBAs
 * 
 * @author venkatsalem@gmail.com
 */
public interface SQLParser {
	public Collection<String> parser(String sqlFileContent);
}
