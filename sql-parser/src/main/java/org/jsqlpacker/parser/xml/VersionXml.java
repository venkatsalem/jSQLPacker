package org.jsqlpacker.parser.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "version")
public class VersionXml {

	private String number;

	private String database;

	private List<SQLFileXml> sqlFiles;

	public VersionXml() {
		sqlFiles = new ArrayList<>();
	}

	@XmlAttribute(name = "number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@XmlElement(name = "sqlfile")
	public List<SQLFileXml> getSqlFiles() {
		return sqlFiles;
	}

	public void setSqlFiles(List<SQLFileXml> sqlFiles) {
		this.sqlFiles = sqlFiles;
	}

	@XmlAttribute(name = "database")
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

}
