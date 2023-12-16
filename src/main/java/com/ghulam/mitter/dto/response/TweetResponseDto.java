package com.ghulam.mitter.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TweetResponseDto {
    private String content;
    private String mediaUrl;
    private LocalDateTime timestamp;
    private List<String> hashtags = new ArrayList<>();
    private UserResponseDto tweeter;
    private List<CommentResponseDto> comments;
}
