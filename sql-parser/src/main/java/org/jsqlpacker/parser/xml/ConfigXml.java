package org.jsqlpacker.parser.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
public class ConfigXml {

	private List<VersionXml> versions;

	public ConfigXml() {
		versions = new ArrayList<>();
	}

	@XmlElement(name = "version")
	public List<VersionXml> getVersions() {
		return versions;
	}

	public void setVersions(List<VersionXml> versions) {
		this.versions = versions;
	}

}
