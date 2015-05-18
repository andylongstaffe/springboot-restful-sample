package com.hollywood.publication.external.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class DesignsDossier {
	
	private int dossierId;
	private String description;
	private String classification;
	private Date registrationDate;
	
	public int getDossierId() {
		return dossierId;
	}
	public void setDossierId(int dossierId) {
		this.dossierId = dossierId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}	
}
