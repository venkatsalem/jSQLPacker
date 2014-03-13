package org.jsqlpacker.parser.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.jsqlpacker.parser.api.SQLParser;

public class SQLParserFactory {

	public static Map<String, SQLParser> factory;

	static {
		factory = new HashMap<>();
		factory.put("sqlserver", new SQLServerParser());
		factory.put("oracle", new OracleParser());
	}

	public static SQLParser getParser(String dbType) {
		return factory.get(dbType.toLowerCase());
	}

}
