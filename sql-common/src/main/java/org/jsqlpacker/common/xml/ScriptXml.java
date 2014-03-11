package org.jsqlpacker.common.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "script")
public class ScriptXml {

	private List<StatementXml> statements;

	public ScriptXml() {
		statements = new ArrayList<>();
	}

	@XmlElement(name = "statement")
	public List<StatementXml> getStatements() {
		return statements;
	}

	public void setStatements(List<StatementXml> statements) {
		this.statements = statements;
	}

}
