package com.ChatClone.B.Login.service;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatClone.B.Login.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
