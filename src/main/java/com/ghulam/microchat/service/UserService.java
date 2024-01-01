package com.ghulam.microchat.service;

import com.ghulam.microchat.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    User findById(String userId);
    User update(String userId, User user);
    void delete(String userId);
    List<User> findAll();

    // todos
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByCountry(String country);
}