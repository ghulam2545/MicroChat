package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Tweet;
import com.ghulam.mitter.dto.request.TweetRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TweetRequestDtoToTweet implements Converter<TweetRequestDto, Tweet> {
    @Override
    public Tweet convert(TweetRequestDto source) {
        Tweet tweet = new Tweet();

        tweet.setContent(source.content());
        tweet.setMediaUrl(source.mediaUrl());
        tweet.setHashtags(source.hashtags());

        return tweet;
    }
}
