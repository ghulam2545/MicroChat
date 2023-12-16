package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.CommentDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDto implements Converter<Comment, CommentDto> {
    @Override
    public CommentDto convert(Comment source) {
        CommentDto commentDto = new CommentDto();

        commentDto.setContent(source.getContent());
        commentDto.setTimestamp(source.getTimestamp());
        commentDto.setCommenter(source.getCommenter());

        return commentDto;
    }
}
