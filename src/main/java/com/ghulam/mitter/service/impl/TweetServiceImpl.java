package com.ghulam.mitter.service.impl;

import com.ghulam.mitter.domain.Tweet;
import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.exception.TweetNotFoundException;
import com.ghulam.mitter.exception.UserNotFoundException;
import com.ghulam.mitter.repository.TweetRepository;
import com.ghulam.mitter.repository.UserRepository;
import com.ghulam.mitter.service.TweetService;
import com.ghulam.mitter.utils.IdGenerator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    public TweetServiceImpl(TweetRepository tweetRepository, UserRepository userRepository, IdGenerator idGenerator) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }


    @Override
    public Tweet save(String userId, Tweet tweet) {
        // set tweet id
        final long id = idGenerator.nextId();
        tweet.setTweetId(id + "");

        // set user
        User tweeter = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        tweet.setTweeter(tweeter);

        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet findById(String tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow();
    }

    @Override
    public Tweet update(String tweetId, Tweet tweet) {
        return tweetRepository.findById(tweetId).map(oldTweet -> {

            oldTweet.setContent(tweet.getContent());
            oldTweet.setMediaUrl(tweet.getMediaUrl());
            oldTweet.setTimestamp(LocalDateTime.now());
            oldTweet.setHashtags(tweet.getHashtags());

            return tweetRepository.save(oldTweet);
        }).orElseThrow(() -> new TweetNotFoundException("tweet not found"));
    }

    @Override
    public void delete(String tweetId) {
        tweetRepository.findById(tweetId).orElseThrow(() -> new TweetNotFoundException("tweet not found"));
        tweetRepository.deleteById(tweetId);
    }

    @Override
    public List<Tweet> findAll() {
        /* todo - implement pagination etc */
        return null;
    }
}
