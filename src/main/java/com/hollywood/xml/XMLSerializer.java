package com.hollywood.xml;

import javax.xml.bind.JAXBException;

public interface XMLSerializer {

	public abstract String toXml(Object object) throws JAXBException;

}