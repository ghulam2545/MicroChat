package com.ghulam.mitter.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String description;
    private String country;
    private String imageUrl;

    @OneToMany(mappedBy = "tweeter", cascade = CascadeType.ALL)
    private List<Tweet> tweets;

    @OneToMany(mappedBy = "commenter", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
