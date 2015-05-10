package com.hollywood.publication.bulletin;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hollywood.publication.request.PublicationRequest;
import com.hollywood.publication.request.PublicationService;

public class BulletinServiceImpl implements BulletinService {

	@Autowired
	PublicationService pubService;
	
	/**
	 * Create a bulletin containing all pending publication requests
	 */
	@Override
	public void createBulletin(String bulletinNumber) {
		Set<PublicationRequest> requests = pubService.getAllPendingRequests();
		//TODO - decide how publication will be generated, use of a bulletin maker, push vs pull, xml/json etc. 
	}

}
