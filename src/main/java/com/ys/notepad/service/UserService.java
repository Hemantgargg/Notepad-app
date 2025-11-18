package com.ys.notepad.service;

import com.ys.notepad.model.User;

public interface UserService {
    User signup(String email, String rawPassword) throws IllegalArgumentException;
    boolean login(String email, String rawPassword);
User findByEmail(String email);



}
