package com.hollywood.publication.external.domain;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Before;
import org.junit.Test;

import com.hollywood.xml.XMLSerializer;
import com.hollywood.xml.impl.SimpleXMLSerializer;

public class TestXmlSerialization {

	private DesignsDossier dossier;
	
	@Before
	public void before() throws Exception {
		dossier = new DesignsDossier();
		dossier.setDossierId(123);
		dossier.setClassification("01/07");
		dossier.setDescription("Boxing glove");
		dossier.setRegistrationDate(new Date());
	}
	
	@Test
	public void testXmlUsingSerializerClass() throws Exception {
		XMLSerializer serializer = new SimpleXMLSerializer(DesignsDossier.class);
		System.out.println(serializer.toXml(dossier));
	}
	
	@Test
	public void testXmlOutput() throws Exception {

		try {

			File file = new File("test-output.xml");
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(DesignsDossier.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(dossier, file);
			jaxbMarshaller.marshal(dossier, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
