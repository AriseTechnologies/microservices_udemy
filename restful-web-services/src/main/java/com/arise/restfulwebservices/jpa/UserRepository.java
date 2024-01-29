package com.arise.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arise.restfulwebservices.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
