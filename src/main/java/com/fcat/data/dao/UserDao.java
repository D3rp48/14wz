package com.fcat.data.dao;

import com.fcat.data.model.User;

public interface UserDao extends GenericDao<User, Integer> {
    User getByEmail(String email);
}
