package com.example.ECF_4_Spring.service;

import com.example.ECF_4_Spring.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    User findByMailAndPassword(String name, String password);
    User save(User user);
    User update(User user);
    void delete(User user);
}
