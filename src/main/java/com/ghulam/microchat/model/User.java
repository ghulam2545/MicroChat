package com.ghulam.microchat.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private String userId;
    private String role;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_link_id")
    private Links links;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
