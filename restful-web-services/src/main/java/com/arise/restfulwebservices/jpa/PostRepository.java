package com.arise.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arise.restfulwebservices.user.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
