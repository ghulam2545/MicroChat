package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.CommentResponse;
import com.ghulam.microchat.model.Comment;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
public class CommentToCommentResponse implements Converter<Comment, CommentResponse> {
    @Override
    public CommentResponse convert(Comment source) {
        return new CommentResponse(
                source.getCommentId(),
                source.getContent()
        );
    }
}
