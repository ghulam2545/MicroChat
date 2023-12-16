package com.ghulam.mitter.dto;

import com.ghulam.mitter.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private String content;
    private LocalDateTime timestamp;
    private User commenter;
}
