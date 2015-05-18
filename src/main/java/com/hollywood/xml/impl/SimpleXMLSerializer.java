package com.hollywood.xml.impl;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.hollywood.xml.XMLSerializer;

public class SimpleXMLSerializer implements XMLSerializer {
	
	private JAXBContext jaxbContext;
	
	public SimpleXMLSerializer(Class... classes) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(classes);
	}

	/* (non-Javadoc)
	 * @see com.hollywood.publication.external.domain.XMLSerializer1#toXml(java.lang.Object, java.lang.Class)
	 */
	@Override
	public String toXml(Object object) throws JAXBException {
		
		StringWriter output = new StringWriter();
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(object, output);	
		return output.toString();
	}
	
}
