package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.request.CommentRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CommentRequestDtoToComment implements Converter<CommentRequestDto, Comment> {
    @Override
    public Comment convert(CommentRequestDto source) {
        Comment comment = new Comment();

        comment.setContent(source.content());

        return comment;
    }
}
