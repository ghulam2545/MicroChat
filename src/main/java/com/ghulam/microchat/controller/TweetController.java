package com.ghulam.microchat.controller;

import com.ghulam.microchat.converter.TweetRequestToTweet;
import com.ghulam.microchat.converter.TweetToTweetResponse;
import com.ghulam.microchat.dto.request.TweetRequest;
import com.ghulam.microchat.dto.response.TweetResponse;
import com.ghulam.microchat.model.Tweet;
import com.ghulam.microchat.service.TweetService;
import com.ghulam.microchat.utils.Result;
import com.ghulam.microchat.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService tweetService;
    private final TweetRequestToTweet tweetRequestToTweet;
    private final TweetToTweetResponse tweetToTweetResponse;

    @PostMapping
    public Result addTweet(@RequestBody TweetRequest tweetRequest) {
        final String userId = tweetRequest.userId();
        Tweet tweet = tweetRequestToTweet.convert(tweetRequest);
        assert tweet != null;

        Tweet savedTweet = tweetService.save(userId, tweet);
        TweetResponse savedTweetResponseDto = tweetToTweetResponse.convert(savedTweet);
        return new Result(true, StatusCode.SUCCESS, "message - addTweet", savedTweetResponseDto);
    }

    @GetMapping("/{tweetId}")
    public Result getTweetById(@PathVariable String tweetId) {
        Tweet tweet = tweetService.findById(tweetId);
        TweetResponse tweetResponseDto = tweetToTweetResponse.convert(tweet);
        return new Result(true, StatusCode.SUCCESS, "message - getTweetById", tweetResponseDto);
    }

    @PutMapping("/{tweetId}")
    public Result updateTweet(@PathVariable String tweetId, @RequestBody TweetRequest tweetRequest) {
        Tweet tweet = tweetRequestToTweet.convert(tweetRequest);
        Tweet updatedTweet = tweetService.update(tweetId, tweet);
        TweetResponse updatedTweetResponseDto = tweetToTweetResponse.convert(updatedTweet);
        return new Result(true, StatusCode.SUCCESS, "message - updateTweet", updatedTweetResponseDto);
    }

    @DeleteMapping("/{tweetId}")
    public Result deleteTweet(@PathVariable String tweetId) {
        tweetService.delete(tweetId);
        return new Result(true, StatusCode.SUCCESS, "message - deleteTweet");
    }

    @GetMapping
    public Result getAllTweet() {
        List<TweetResponse> result = tweetService.findAll().stream().map(tweetToTweetResponse::convert).toList();
        return new Result(true, StatusCode.SUCCESS, "message - getAllTweet", result);
    }
}
