package com.fcat.data.dao.impl;

import com.fcat.data.dao.GroupPropertyDao;
import com.fcat.data.model.GroupProperty;
import org.springframework.stereotype.Repository;

@Repository
public class GroupPropertyDaoImpl extends GenericDaoImpl<GroupProperty, Integer> implements GroupPropertyDao {
    public GroupPropertyDaoImpl() {
        super(GroupProperty.class);
    }
}
