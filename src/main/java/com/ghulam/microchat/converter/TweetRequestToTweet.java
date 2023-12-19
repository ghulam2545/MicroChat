package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.TweetRequest;
import com.ghulam.microchat.model.Tweet;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
public class TweetRequestToTweet implements Converter<TweetRequest, Tweet> {
    @Override
    public Tweet convert(TweetRequest source) {
        Tweet tweet = new Tweet();
        tweet.setContent(source.content());

        return tweet;
    }
}
