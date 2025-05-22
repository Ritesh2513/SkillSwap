package com.example.teachlearn.Repository;

import com.example.teachlearn.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByVerificationToken(String verificationToken);
}




