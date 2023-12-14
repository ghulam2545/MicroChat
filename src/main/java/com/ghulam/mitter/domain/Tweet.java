package com.ghulam.mitter.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tweet {
    @Id
    private String id;
    private String content;
    private String mediaUrl;
    private LocalDateTime timestamp;

    @ElementCollection
    private List<String> hashtags = new ArrayList<>();

    @ManyToOne
    private User tweeter;
}
