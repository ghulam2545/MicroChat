package com.ghulam.mitter.service.impl;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.repository.UserRepository;
import com.ghulam.mitter.service.UserService;
import com.ghulam.mitter.utils.IdGenerator;
import com.ghulam.mitter.utils.UserPrinciple;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, IdGenerator idGenerator, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        final long id = idGenerator.nextId();
        user.setUserId(id + "");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("user");

        return userRepository.save(user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElseThrow( /* handle exception */ );
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
        }).orElseThrow( /* handle exception */ );
    }

    @Override
    public void delete(String userId) {
        userRepository.findById(userId).orElseThrow( /* handle exception */ );
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findAll() {
        /* todo - implement pagination etc */
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByUsername(username).map(UserPrinciple::new)
                .orElseThrow( /* handle exception */ );
    }
}
