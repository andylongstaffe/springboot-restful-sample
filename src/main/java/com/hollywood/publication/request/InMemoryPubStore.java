package com.hollywood.publication.request;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPubStore implements PublicationDao {

	Map<String, PublicationRequest> requests;
	
	public InMemoryPubStore() {
		requests = new HashMap<String, PublicationRequest>();
	}
	
	@Override
	public boolean createRequest(String designNumber) {
		requests.put(designNumber, new PublicationRequest(designNumber));
		return true;
	}

	@Override
	public PublicationRequest get(String designNumber) {
		return requests.get(designNumber);
	}

	@Override
	public Set<PublicationRequest> getallPendingRequests() {
		// this needs to be amended to only return pending reqs
		System.out.println(requests.size());
		return new HashSet<PublicationRequest>(requests.values());		
	}

}
