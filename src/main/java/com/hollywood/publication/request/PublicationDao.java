package com.hollywood.publication.request;

import java.util.List;
import java.util.Set;

public interface PublicationDao {

	boolean createRequest(String designNumber);

	PublicationRequest get(String designNumber);

	Set<PublicationRequest> getallPendingRequests();

}
