package org.jsqlpacker.parser.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConfigXmlUtil {

	private ConfigXmlUtil() {
		throw new Error("Contains only static methods");
	}

	public static String toString(ConfigXml configXml) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ConfigXml.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();
		marshaller.marshal(configXml, writer);
		return writer.toString();
	}

	public static ConfigXml toObject(String xml) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ConfigXml.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (ConfigXml) unmarshaller.unmarshal(new StringReader(xml));
	}
}
