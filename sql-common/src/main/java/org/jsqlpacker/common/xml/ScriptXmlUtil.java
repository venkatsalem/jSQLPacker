package org.jsqlpacker.common.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ScriptXmlUtil {

	private ScriptXmlUtil() {
		throw new Error("Contains only static methods");
	}

	public static String toString(ScriptXml xml) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ScriptXml.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();
		marshaller.marshal(xml, writer);
		return writer.toString();
	}

	public static ScriptXml toObject(String xml) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ScriptXml.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (ScriptXml) unmarshaller.unmarshal(new StringReader(xml));
	}
}
