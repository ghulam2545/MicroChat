package com.ghulam.mitter.service;

import com.ghulam.mitter.domain.Tweet;
import java.util.List;

public interface TweetService {
    Tweet save(Tweet tweet);
    Tweet findById(String tweetId);
    Tweet update(String tweetId, Tweet tweet);
    void delete(String tweetId);
    List<Tweet> findAll();
}
