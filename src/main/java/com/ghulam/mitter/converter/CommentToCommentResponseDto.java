package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.response.CommentResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CommentToCommentResponseDto implements Converter<Comment, CommentResponseDto> {
    @Override
    public CommentResponseDto convert(Comment source) {
        return null;
    }
}
