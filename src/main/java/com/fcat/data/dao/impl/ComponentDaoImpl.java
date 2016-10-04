package com.fcat.data.dao.impl;

import com.fcat.data.dao.ComponentDao;
import com.fcat.data.model.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDaoImpl extends GenericDaoImpl<Component, Integer> implements ComponentDao {

    public ComponentDaoImpl() {
        super(Component.class);
    }
}
