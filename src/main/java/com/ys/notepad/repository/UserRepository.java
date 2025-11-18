package com.ys.notepad.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ys.notepad.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
