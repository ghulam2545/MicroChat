package com.ghulam.mitter.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Tweet {
    @Id
    private String tweetId;
    private String content;
    private String mediaUrl;
    private LocalDateTime timestamp;

    @ElementCollection
    private List<String> hashtags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User tweeter;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Comment> comments;
}