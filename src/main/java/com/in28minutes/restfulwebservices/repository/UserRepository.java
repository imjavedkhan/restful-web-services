package com.in28minutes.restfulwebservices.repository;

import com.in28minutes.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
