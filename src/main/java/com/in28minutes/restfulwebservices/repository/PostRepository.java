package com.in28minutes.restfulwebservices.repository;

import com.in28minutes.restfulwebservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
