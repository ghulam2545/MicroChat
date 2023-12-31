package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.CommentRequest;
import com.ghulam.microchat.model.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentRequestToComment implements Converter<CommentRequest, Comment> {
    @Override
    public Comment convert(CommentRequest source) {
        Comment comment = new Comment();

        comment.setContent(source.content());

        return comment;
    }
}
