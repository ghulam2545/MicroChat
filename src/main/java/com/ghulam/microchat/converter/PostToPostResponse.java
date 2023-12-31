package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.PostResponse;
import com.ghulam.microchat.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostToPostResponse implements Converter<Post, PostResponse> {
    @Override
    public PostResponse convert(Post source) {
        return new PostResponse(
                source.getPostId(),
                source.getContent(),
                source.getMediaUrl(),
                source.getLastUpdate()
        );
    }
}
