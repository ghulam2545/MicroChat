package com.ghulam.microchat.service;

import com.ghulam.microchat.model.Role;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.UserRepository;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow( () -> new UsernameNotFoundException("User not found"));
    }

    public User save(User user) {
        final long id = idGenerator.nextId();
        user.setId(id + "");

        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    public User findById(String userId) {
        return userRepository.findById(userId).orElseThrow( /* handle exception */ );
    }

    public User update(String userId, User user) {
        return userRepository.findById(userId).map(oldUser -> {

            oldUser.setFullname(user.getFullname());
            oldUser.setEmail(user.getEmail());

            return userRepository.save(oldUser);
        }).orElseThrow( /* handle exception */ );
    }

    public void delete(String userId) {
        userRepository.findById(userId).orElseThrow( /* handle exception */ );
        userRepository.deleteById(userId);
    }

    public List<User> findAll() {
        /* todo - implement pagination etc */
        return userRepository.findAll();
    }
}
