package com.hollywood.publication.bulletin.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hollywood.publication.bulletin.BulletinService;

@RestController
@RequestMapping("bulletin")
public class BulletinController {

	@Autowired
	BulletinService bulletinService;
	
	@RequestMapping(value = "/{bulletinNumber}", method = RequestMethod.PUT)
	public ResponseEntity<Void> createBulletin(@PathVariable String bulletinNumber) throws URISyntaxException {
		bulletinService.createBulletin(bulletinNumber);
		return ResponseEntity.created(new URI("/bulletin/" + bulletinNumber)).build();
	}
	
}
