package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.PostRequest;
import com.ghulam.microchat.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostRequestToPost implements Converter<PostRequest, Post> {
    @Override
    public Post convert(PostRequest source) {
        Post post = new Post();

        post.setContent(source.content());
        post.setMediaUrl(source.mediaUrl());

        return post;
    }
}
