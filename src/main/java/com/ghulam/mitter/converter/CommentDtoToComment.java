package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.CommentDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToComment implements Converter<CommentDto, Comment> {
    @Override
    public Comment convert(CommentDto source) {
        Comment comment = new Comment();

        comment.setContent(source.getContent());
        comment.setTimestamp(source.getTimestamp());
        comment.setCommenter(source.getCommenter());

        return comment;
    }
}
