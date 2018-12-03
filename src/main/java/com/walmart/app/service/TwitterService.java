/**
 * 
 */
package com.walmart.app.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author maagapi
 *
 */
@Service
public class TwitterService {

	private Twitter twitter;

	@PostConstruct
	public void init() {
		twitter = TwitterFactory.getSingleton();
	}

	public List<Status> getStatusByquery(String query) throws TwitterException {
		QueryResult search = twitter.search(new Query(query));
		return search.getTweets();
	}
}
