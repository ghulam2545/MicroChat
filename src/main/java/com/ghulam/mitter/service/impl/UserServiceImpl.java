package com.ghulam.mitter.service.impl;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.exception.UserNotFoundException;
import com.ghulam.mitter.repository.UserRepository;
import com.ghulam.mitter.service.UserService;
import com.ghulam.mitter.utils.IdGenerator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    public UserServiceImpl(UserRepository userRepository, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public User save(User user) {
        final long id = idGenerator.nextId();
        user.setUserId(id + "");
        return userRepository.save(user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public User update(String userId, User user) {
        return userRepository.findById(userId).map(oldUser -> {

            oldUser.setUsername(user.getUsername());
            oldUser.setFullname(user.getFullname());
            oldUser.setDescription(user.getDescription());
            oldUser.setCountry(user.getCountry());
            oldUser.setImageUrl(user.getImageUrl());

            return userRepository.save(oldUser);
        }).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public void delete(String userId) {
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findAll() {
        /* todo - implement pagination etc */
        return userRepository.findAll();
    }
}
