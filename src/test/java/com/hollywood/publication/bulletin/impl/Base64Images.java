package com.hollywood.publication.bulletin.impl;

public class Base64Images {

	public static String GUITAR = "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";
	
}