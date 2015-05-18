package com.hollywood.publication.bulletin.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hollywood.publication.bulletin.Bulletin;
import com.hollywood.publication.bulletin.BulletinItem;
import com.hollywood.publication.bulletin.BulletinService;
import com.hollywood.publication.bulletin.BulletinWriter;
import com.hollywood.publication.external.domain.DesignsDossier;
import com.hollywood.publication.external.service.DossierService;
import com.hollywood.publication.request.PublicationRequest;
import com.hollywood.publication.request.PublicationService;

public class BulletinServiceImpl implements BulletinService {

	@Autowired
	PublicationService pubService;
	@Autowired
	private DossierService dossierService;
	
	/**
	 * Create a bulletin containing all pending publication requests
	 */
	@Override
	public void createBulletin(String bulletinNumber) {
		Set<PublicationRequest> requests = pubService.getAllPendingRequests();
		//TODO - decide how publication will be generated, use of a bulletin maker, push vs pull, xml/json etc. 
		Bulletin bulletin = new BulletinImpl();
		for ( PublicationRequest pr : requests ) {
			DesignsDossier dossier = dossierService.getDossier(pr.getId());
			BulletinItem item = (BulletinItem) dossier;
			bulletin.addItem(item);			
		}
		BulletinWriter htmlWriter = new HTMLBulletinWriter(bulletin);
		htmlWriter.write();
		BulletinWriter pdfWriter = new PDFBulletinWriter(bulletin);
		pdfWriter.write();
	}

}
