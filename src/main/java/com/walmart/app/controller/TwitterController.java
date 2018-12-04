/**
 * 
 */
package com.walmart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.app.service.TwitterService;

import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * @author maagapi
 *
 */
@RestController
@RequestMapping("/tweets")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	@RequestMapping("/search")
	@ResponseBody
	public ResponseEntity<List<Status>> getWinByEmployeeId(@RequestParam("q") String query) throws TwitterException {
		return new ResponseEntity<>(twitterService.getStatusByquery(query), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Status> postStatus(HttpEntity<String> httpEntity) throws TwitterException {
		return new ResponseEntity<>(twitterService.postStatus(httpEntity.getBody()), HttpStatus.OK);
	}
}
