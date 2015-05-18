package com.hollywood.publication.bulletin.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.hollywood.publication.bulletin.BulletinItem;
import com.hollywood.publication.external.domain.DesignsDossier;

public class DesignsVelocityBulletinItem implements BulletinItem {

	DesignsDossier dossier;
	
	public DesignsVelocityBulletinItem(DesignsDossier dossier) {
		this.dossier = dossier;
	}
	
	@Override
	public String html() {
		//Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM, this);
		Velocity.init();
		Template bulletinItem = Velocity.getTemplate("src/main/resources/templates/designsBulletinItem.template.html");
		StringWriter writer = new StringWriter();
		VelocityContext context = new VelocityContext();
		context.put("design", dossier);
		context.put("image", Base64Images.GUITAR);
		bulletinItem.merge(context, writer);
		return writer.toString();
	}

}
