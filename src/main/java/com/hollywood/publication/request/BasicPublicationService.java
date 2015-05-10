package com.hollywood.publication.request;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPublicationService implements PublicationService {

	private static Log log = LogFactory.getLog(PublicationRequestController.class);
	
	// why was this bug being reported silently when not annotated ????
	@Autowired
	private PublicationDao dao;
	
	@Override
	public boolean createRequest(String designNumber) {
		log.info("Publication requested for design " + designNumber);
		dao.createRequest(designNumber);
		return true;
	}

	@Override
	public PublicationRequest get(String designNumber) {
		log.info("Retrieving pub request for design " + designNumber);
		return dao.get(designNumber);
	}

	@Override
	public Set<PublicationRequest> getAllPendingRequests() {
		log.info("Retrieving all pending pub requests");
		return dao.getallPendingRequests();
	}

}
