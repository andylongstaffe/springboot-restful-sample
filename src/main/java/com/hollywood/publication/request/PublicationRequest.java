package com.hollywood.publication.request;

import java.sql.Date;

public class PublicationRequest {

	private String id;
	private Date requestDate;
	private String status;
	private String requestUser;
	
	public PublicationRequest(String designNumber) {
		id = designNumber;
		status = "pending";
		requestUser = "tobedone";
		requestDate = null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequestUser() {
		return requestUser;
	}
	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}
	
}
