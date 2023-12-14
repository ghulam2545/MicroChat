package com.ghulam.mitter.service;

import com.ghulam.mitter.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(String userId);
    User update(String userId, User user);
    void delete(String userId);
    List<User> findAll();
}
