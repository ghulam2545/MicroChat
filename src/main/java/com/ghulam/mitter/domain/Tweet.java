package com.ghulam.mitter.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
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
    private String hashtags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Comment> comments;
}