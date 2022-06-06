package com.example.jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
