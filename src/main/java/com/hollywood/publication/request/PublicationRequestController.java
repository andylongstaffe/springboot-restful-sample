package com.hollywood.publication.request;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publication/request")
public class PublicationRequestController {

	private static Log log = LogFactory.getLog(PublicationRequestController.class);

	@Autowired
	PublicationService pubService;

	@RequestMapping(value = "/design/{designNumber}", method = RequestMethod.PUT)
	public ResponseEntity<Void> createDesignRequest(@PathVariable String designNumber) throws URISyntaxException {
		pubService.createRequest(designNumber);
		return ResponseEntity.created(new URI("/publication/request/design/" + designNumber)).build();
	}
	
	@RequestMapping(value = "/design/{designNumber}", method = RequestMethod.GET)
	public ResponseEntity<PublicationRequest> getDesignRequest(@PathVariable String designNumber) throws URISyntaxException {
		PublicationRequest pr = pubService.get(designNumber);
		return ResponseEntity.ok(pr);
	}

	@RequestMapping(value = "/design/pending", method = RequestMethod.GET)
	public Set<PublicationRequest> allPendingDesignRequests() {
		return pubService.getAllPendingRequests();
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
