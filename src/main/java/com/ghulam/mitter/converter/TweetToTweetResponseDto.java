package com.ghulam.mitter.converter;


import com.ghulam.mitter.domain.Tweet;
import com.ghulam.mitter.dto.response.TweetResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TweetToTweetResponseDto implements Converter<Tweet, TweetResponseDto> {
    private final UserToUserResponseDto userToUserResponseDto;
    private final CommentToCommentResponseDto commentToCommentResponseDto;

    public TweetToTweetResponseDto(UserToUserResponseDto userToUserResponseDto, CommentToCommentResponseDto commentToCommentResponseDto) {
        this.userToUserResponseDto = userToUserResponseDto;
        this.commentToCommentResponseDto = commentToCommentResponseDto;
    }

    @Override
    public TweetResponseDto convert(Tweet source) {
        TweetResponseDto dto = new TweetResponseDto();

        dto.setContent(source.getContent());
        dto.setMediaUrl(source.getMediaUrl());
        dto.setTimestamp(source.getTimestamp());
        dto.setHashtags(source.getHashtags());
        dto.setTweeter(userToUserResponseDto.convert(source.getTweeter()));

        // todo
        dto.setComments(null);

        return dto;
    }
}
