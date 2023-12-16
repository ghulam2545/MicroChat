package com.ghulam.mitter.controller;

import com.ghulam.mitter.converter.TweetRequestDtoToTweet;
import com.ghulam.mitter.converter.TweetToTweetResponseDto;
import com.ghulam.mitter.domain.Tweet;
import com.ghulam.mitter.dto.request.TweetRequestDto;
import com.ghulam.mitter.dto.response.TweetResponseDto;
import com.ghulam.mitter.service.TweetService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService tweetService;
    private final TweetRequestDtoToTweet tweetRequestDtoToTweet;
    private final TweetToTweetResponseDto tweetToTweetResponseDto;

    public TweetController(TweetService tweetService, TweetRequestDtoToTweet tweetRequestDtoToTweet, TweetToTweetResponseDto tweetToTweetResponseDto) {
        this.tweetService = tweetService;
        this.tweetRequestDtoToTweet = tweetRequestDtoToTweet;
        this.tweetToTweetResponseDto = tweetToTweetResponseDto;
    }

    @PostMapping
    public Result addTweet(@RequestBody TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetRequestDtoToTweet.convert(tweetRequestDto);

        Tweet savedTweet = tweetService.save(tweet);
        TweetResponseDto savedTweetResponseDto = tweetToTweetResponseDto.convert(savedTweet);
        return new Result(true, StatusCode.SUCCESS, "message - addTweet", savedTweetResponseDto);
    }

    @GetMapping("/{tweetId}")
    public Result getTweetById(@PathVariable String tweetId) {
        Tweet tweet = tweetService.findById(tweetId);
        TweetResponseDto tweetResponseDto = tweetToTweetResponseDto.convert(tweet);
        return new Result(true, StatusCode.SUCCESS, "message - getTweetById", tweetResponseDto);
    }

    @PutMapping("/{tweetId}")
    public Result updateTweet(@PathVariable String tweetId, @RequestBody TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetRequestDtoToTweet.convert(tweetRequestDto);
        Tweet updatedTweet = tweetService.update(tweetId, tweet);
        TweetResponseDto updatedTweetResponseDto = tweetToTweetResponseDto.convert(updatedTweet);
        return new Result(true, StatusCode.SUCCESS, "message - updateTweet", updatedTweetResponseDto);
    }

    @DeleteMapping("/{tweetId}")
    public Result deleteTweet(@PathVariable String tweetId) {
        tweetService.delete(tweetId);
        return new Result(true, StatusCode.SUCCESS, "message - deleteTweet");
    }

    @GetMapping
    public Result getAllTweet() {
        List<Tweet> allTweet = tweetService.findAll();

        // todo
        return new Result(true, StatusCode.SUCCESS, "message - getAllTweet", allTweet);
    }
}
