package com.fcat.data.dao.impl;

import com.fcat.data.dao.GroupPropertyDao;
import com.fcat.data.model.PropertyKey;
import org.springframework.stereotype.Repository;

@Repository
public class GroupPropertyDaoImpl extends GenericDaoImpl<PropertyKey, Integer> implements GroupPropertyDao {
    public GroupPropertyDaoImpl() {
        super(PropertyKey.class);
    }
}
