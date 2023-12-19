package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.TweetResponse;
import com.ghulam.microchat.model.Tweet;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
public class TweetToTweetResponse implements Converter<Tweet, TweetResponse> {
    @Override
    public TweetResponse convert(Tweet source) {
        return new TweetResponse(
                source.getTweetId(),
                source.getContent()
        );
    }
}
