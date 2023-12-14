package com.ghulam.mitter.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    private String id;
    private String content;
    private LocalDateTime timestamp;

    @ManyToOne
    private User commenter;
}
