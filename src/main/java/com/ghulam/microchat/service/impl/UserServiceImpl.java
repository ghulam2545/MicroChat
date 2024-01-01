package com.ghulam.microchat.service.impl;

import com.ghulam.microchat.exception.UserNotFoundException;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.UserRepository;
import com.ghulam.microchat.service.UserService;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setRole("ROLE_USER");
        user.setUserId(IdGenerator.next());

        return userRepository.save(user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found exception."));
    }

    @Override
    public User update(String userId, User user) {
        return userRepository.findById(userId).map(oldUser -> {

            // update data
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setUsername(user.getUsername());
            oldUser.setCountry(user.getCountry());
            oldUser.setLinks(user.getLinks());

            return userRepository.save(oldUser);
        }).orElseThrow(() -> new UserNotFoundException("user not found exception."));
    }

    @Override
    public void delete(String userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found exception."));

        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findAll() {
        /* todo - implement pagination etc */
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByCountry(String country) {
        return Optional.empty();
    }

}
