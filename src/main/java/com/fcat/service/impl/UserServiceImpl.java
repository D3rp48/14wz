package com.fcat.service.impl;

import com.fcat.data.dao.UserDao;
import com.fcat.data.model.User;
import com.fcat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> getById(int id) {
        return Optional.ofNullable(userDao.getById(id));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(userDao.getByEmail(email));
    }

    @Override
    public List<User> getAll() {
        return userDao.list();
    }

    @Override
    public void create(User user) {
        userDao.save(user);
    }
}
