package org.jsqlpacker.common.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "script")
public class ScriptXml {

	private String database;

	private String version;

	private List<String> statements;

	public ScriptXml() {
		statements = new ArrayList<>();
	}

	@XmlElement(name = "statement")
	public List<String> getStatements() {
		return statements;
	}

	public void setStatements(List<String> statements) {
		this.statements = statements;
	}

	@XmlAttribute(name = "database")
	public String getDatabase() {
		return database;
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
