package com.hollywood.publication.bulletin.impl;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;
import com.hollywood.publication.external.domain.DesignsDossier;

public class TestDesignsBulletinItem {

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
	public void testStandardOutput() throws Exception {
		DesignsBulletinItem item = new DesignsBulletinItem(dossier);
		System.out.println(item.html());
	}
	
	@Test
	public void testPageOutput() throws Exception {
		DesignsBulletinItem item = new DesignsBulletinItem(dossier);	
		String output = "<html>" + item.html() + "</html>";
		Files.write(output.getBytes(), Paths.get("test-bulletin.html").toFile());
	}
	
	
	
}
