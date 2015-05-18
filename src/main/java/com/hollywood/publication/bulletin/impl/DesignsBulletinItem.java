package com.hollywood.publication.bulletin.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hollywood.publication.bulletin.BulletinItem;
import com.hollywood.publication.external.domain.DesignsDossier;

public class DesignsBulletinItem implements BulletinItem {

	DesignsDossier dossier;
	
	public DesignsBulletinItem(DesignsDossier dossier) {
		this.dossier = dossier;
	}
	
	@Override
	public String html() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div>");
		sb.append("<table border=\"1\">");
		sb.append("<tr><td>" + dossier.getDossierId() + "</td><td>" + dossier.getDescription() + "</td></tr>");
		sb.append("<tr><td colspan=\"2\">" + base64Image(Base64Images.GUITAR) + "</td></tr>");
		sb.append("<tr><td colspan=\"2\">" + formatDate(dossier.getRegistrationDate()) + "</td></tr>");
		sb.append("<tr><td colspan=\"2\">" + dossier.getClassification() + "</td></tr>");
		sb.append("</table>");
		sb.append("</div>");
		return sb.toString();
	}

	private String formatDate(Date registrationDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(registrationDate);
	}
	
	/**
	 * 
	 * @param encode Base 64 encoded string
	 * @return
	 */
	private String base64Image(String encode) {
		return "<img src=\"data:image/jpg;base64," + encode + "\"";
	}

}
