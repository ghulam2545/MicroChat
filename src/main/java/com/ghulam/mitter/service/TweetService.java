package com.ghulam.mitter.service;

import com.ghulam.mitter.domain.Tweet;

import java.util.List;

public interface TweetService {
    Tweet save();
    Tweet findById();
    Tweet update();
    void delete();
    List<Tweet> findAll();
}
