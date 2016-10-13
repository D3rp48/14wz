package com.fcat.data.dao.impl;

import com.fcat.data.dao.GroupDao;
import com.fcat.data.model.PropertyGroup;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<PropertyGroup, String> implements GroupDao {
    public GroupDaoImpl() {
        super(PropertyGroup.class);
    }
}
