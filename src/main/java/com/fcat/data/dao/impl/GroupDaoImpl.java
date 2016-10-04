package com.fcat.data.dao.impl;

import com.fcat.data.dao.GroupDao;
import com.fcat.data.model.GroupType;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<GroupType, String> implements GroupDao {
    public GroupDaoImpl() {
        super(GroupType.class);
    }
}
