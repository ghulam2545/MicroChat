package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Tweet;
import com.ghulam.mitter.dto.response.TweetResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TweetToTweetResponseDto implements Converter<Tweet, TweetResponseDto> {
    @Override
    public TweetResponseDto convert(Tweet source) {
        return new TweetResponseDto(
                source.getTweetId(),
                source.getContent(),
                source.getMediaUrl(),
                source.getTimestamp(),
                source.getHashtags()
        );
    }
}
