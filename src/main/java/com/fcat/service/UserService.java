package com.fcat.service;

import com.fcat.data.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getById(int id);

    Optional<User> getByEmail(String email);

    List<User> getAll();

    void create(User user);
}
