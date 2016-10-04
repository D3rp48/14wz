package com.fcat.data.dao.impl;

import com.fcat.data.dao.UserDao;
import com.fcat.data.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByEmail(String email) {
        return findUniqueByExpressions(Restrictions.eq("email", email));
    }
}
