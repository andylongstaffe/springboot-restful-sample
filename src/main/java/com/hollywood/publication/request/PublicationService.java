package com.hollywood.publication.request;

import java.util.Set;

public interface PublicationService {
	
	boolean createRequest(String designNumber);
	
	PublicationRequest get(String designNumber);
	
	Set<PublicationRequest> getAllPendingRequests();
}
