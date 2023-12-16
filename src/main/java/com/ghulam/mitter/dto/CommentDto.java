package com.ghulam.mitter.dto;

import com.ghulam.mitter.domain.User;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private String content;
    private LocalDateTime timestamp;
    private User commenter;
}
