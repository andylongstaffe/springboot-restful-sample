package com.hollywood.dozer;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hollywood.publication.external.domain.DesignsDossier;
import com.hollywood.publication.ui.domain.DesignsDossierUI;

public class DozerTest {

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
	public void testBasicMapping() throws Exception {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		DesignsDossierUI dossierUI = mapper.map(dossier, DesignsDossierUI.class);
		System.out.println(new ReflectionToStringBuilder(dossierUI, ToStringStyle.SHORT_PREFIX_STYLE));
		Assert.assertEquals(dossier.getDossierId(), dossierUI.getId());
		Assert.assertEquals(dossier.getDescription(), dossierUI.getDescription());
		Assert.assertEquals(dossier.getClassification(), dossierUI.getLocarnoCode());
		Assert.assertEquals(dossier.getRegistrationDate(), dossierUI.getRegistrationDate());
		Assert.assertEquals(dossier.getSummary(), dossierUI.getSummary());
	}
	
}
