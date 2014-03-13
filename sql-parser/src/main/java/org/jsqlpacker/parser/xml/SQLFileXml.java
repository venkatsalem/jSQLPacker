package org.jsqlpacker.parser.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sqlfile")
public class SQLFileXml {

	private String dir;

	private String fileName;

	@XmlAttribute(name = "dir")
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	@XmlAttribute(name = "file")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
