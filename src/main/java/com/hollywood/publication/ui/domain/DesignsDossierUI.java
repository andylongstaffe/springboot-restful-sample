package com.hollywood.publication.ui.domain;

import java.util.Date;

public class DesignsDossierUI {

	private int id;
	private String description;
	private String locarnoCode;
	private Date registrationDate;
	private String summary;
	
	public int getId() {
		return id;
	}
	public void setId(int dossierId) {
		this.id = dossierId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocarnoCode() {
		return locarnoCode;
	}
	public void setLocarnoCode(String locarnoCode) {
		this.locarnoCode = locarnoCode;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
