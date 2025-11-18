package com.ys.notepad.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ys.notepad.model.User;
import com.ys.notepad.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signup(String email, String rawPassword) throws IllegalArgumentException {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (rawPassword == null || rawPassword.length() < 4) {
            throw new IllegalArgumentException("Password must be at least 4 characters");
        }

        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("User already exists with this email");
        }

        String encoded = passwordEncoder.encode(rawPassword);
        User user = User.builder()
                        .email(email)
                        .password(encoded)
                        .build();
        return userRepository.save(user);
    }

    @Override
    public boolean login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) return false;
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    @Override
public User findByEmail(String email) {
    return userRepository.findByEmail(email);
}

}
