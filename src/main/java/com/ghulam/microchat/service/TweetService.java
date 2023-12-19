package com.ghulam.microchat.service;

import com.ghulam.microchat.model.Tweet;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.TweetRepository;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserService userService;
    private final IdGenerator idGenerator;

    public Tweet save(String userId, Tweet tweet) {
        // set tweet id
        final long id = idGenerator.nextId();
        tweet.setTweetId(id + "");

        // set user
        User user = userService.findById(userId);
        tweet.setUser(user);

        return tweetRepository.save(tweet);
    }

    public Tweet findById(String tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow( /* handle exception */ );
    }

    public Tweet update(String tweetId, Tweet tweet) {
        return tweetRepository.findById(tweetId).map(oldTweet -> {

            oldTweet.setContent(tweet.getContent());

            return tweetRepository.save(oldTweet);
        }).orElseThrow( /* handle exception */ );
    }

    public void delete(String tweetId) {
        tweetRepository.findById(tweetId).orElseThrow( /* handle exception */ );
        tweetRepository.deleteById(tweetId);
    }

    public List<Tweet> findAll() {
        /* todo - implement pagination etc */
        return null;
    }
}
