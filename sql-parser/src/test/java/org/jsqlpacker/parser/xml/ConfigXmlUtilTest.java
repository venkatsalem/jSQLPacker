package org.jsqlpacker.parser.xml;

import javax.xml.bind.JAXBException;

import junit.framework.TestCase;

public class ConfigXmlUtilTest extends TestCase {

	public void testToString() throws JAXBException {
		ConfigXml configXml = new ConfigXml();
		{
			VersionXml versionXml = new VersionXml();
			versionXml.setNumber("1.0");
			versionXml.setDatabase("sqlserver");
			SQLFileXml sqlFile = new SQLFileXml();
			sqlFile.setDir("src/test/resources");
			versionXml.getSqlFiles().add(sqlFile);
			configXml.getVersions().add(versionXml);
		}
		System.out.println(ConfigXmlUtil.toString(configXml));
	}
}
