package org.jsqlpacker.parser.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.jsqlpacker.parser.api.SQLParseException;
import org.jsqlpacker.parser.api.impl.SQLServerParser;

public class SQLServerParserTest extends TestCase {

	public void test() throws IOException, SQLParseException {
		InputStream in = SQLServerParserTest.class
				.getResourceAsStream("/sqlserver-sample.sql");
		String sqlScript = IOUtils.toString(in);
		Collection<String> statements = new SQLServerParser().parser(sqlScript);
		for (String sql : statements) {
			System.out.println(sql);
			System.out.println("-----------------------------");
		}
	}

}
