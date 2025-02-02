package com.example.main.repository;

import com.example.main.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
