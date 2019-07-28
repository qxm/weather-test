package com.qxm.weather.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
	private static final Logger log = LoggerFactory.getLogger( RestClient.class);
	@Value("${weather.server.uri}")
	private String server;
	@Value("${weather.server.suffix}")
	private String suffix;
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public RestClient() {
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}

	public String get(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		log.info("Retrieve uri: {}",server + uri + suffix);
		
		ResponseEntity<String> responseEntity = rest.exchange(server + uri + suffix, HttpMethod.GET, requestEntity,
				String.class);
		
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}


	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
