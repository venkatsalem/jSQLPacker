package org.jsqlpacker.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jsqlpacker.common.xml.ScriptXml;
import org.jsqlpacker.common.xml.ScriptXmlUtil;
import org.jsqlpacker.parser.api.SQLParseException;
import org.jsqlpacker.parser.api.SQLParser;
import org.jsqlpacker.parser.api.impl.SQLParserFactory;
import org.jsqlpacker.parser.xml.ConfigXml;
import org.jsqlpacker.parser.xml.ConfigXmlUtil;
import org.jsqlpacker.parser.xml.SQLFileXml;
import org.jsqlpacker.parser.xml.VersionXml;

/**
 * This class responsible to take input xml and generate xml which is compatible for packer to execute against database
 * 
 * @author Venkat Sadasivam
 */
public class Main {

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			System.err.println("This program need one argument with config xml file path");
			return;
		}
		try {
			ConfigXml configXml = ConfigXmlUtil.toObject(IOUtils.toString(new FileInputStream(args[0])));
			main(configXml);
		} catch (Throwable throwable) {
			System.err.println(throwable.getMessage());
		}

	}

	public static void main(ConfigXml configXml) throws Exception {
		List<VersionXml> versions = configXml.getVersions();
		Map<String, Map<String, ScriptXml>> databases = new HashMap<String, Map<String, ScriptXml>>();
		for (VersionXml version : versions) {
			List<SQLFileXml> files = version.getSqlFiles();
			for (SQLFileXml sqlFile : files) {
				SQLParser parser = SQLParserFactory.getParser(version.getDatabase());
				if (parser == null) {
					throw new RuntimeException("Unsupported database type: " + version.getDatabase());
				}
				Map<String, ScriptXml> versionXml = databases.get(version.getDatabase().toLowerCase());
				if (versionXml == null) {
					versionXml = new HashMap<>();
					databases.put(version.getDatabase().toLowerCase(), versionXml);
				}
				ScriptXml scriptXml = versionXml.get(version.getNumber());
				if (scriptXml == null) {
					scriptXml = new ScriptXml();
					scriptXml.setDatabase(version.getDatabase().toLowerCase());
					scriptXml.setVersion(version.getNumber());
					versionXml.put(version.getNumber(), scriptXml);
				}
				List<File> filesToBeParsed = new ArrayList<>();
				File directory = new File(sqlFile.getDir());
				for (File file : directory.listFiles()) {
					if (file.getName().toLowerCase().endsWith(".sql")) {
						filesToBeParsed.add(file);
					}
				}
				for (File file : filesToBeParsed) {
					try {
						Collection<String> statements = parser.parser(IOUtils.toString(new FileInputStream(file)));
						scriptXml.getStatements().addAll(statements);
					} catch (SQLParseException | IOException e) {
						e.printStackTrace();
						throw new RuntimeException("Error while parsing file: " + file.getAbsolutePath());
					}
				}
			}
		}
		for (Map.Entry<String, Map<String, ScriptXml>> database : databases.entrySet()) {
			for (Map.Entry<String, ScriptXml> entry2 : database.getValue().entrySet()) {
				System.out.println(ScriptXmlUtil.toString(entry2.getValue()));
			}
		}
	}
}
