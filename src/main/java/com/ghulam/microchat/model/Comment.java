package com.ghulam.microchat.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    private String commentId;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_post_id")
    private Post post;
}
