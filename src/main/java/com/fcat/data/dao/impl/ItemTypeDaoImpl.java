package com.fcat.data.dao.impl;

import com.fcat.data.dao.ItemTypeDao;
import com.fcat.data.model.ItemType;
import org.springframework.stereotype.Repository;

@Repository
public class ItemTypeDaoImpl extends GenericDaoImpl<ItemType, String> implements ItemTypeDao {
    public ItemTypeDaoImpl() {
        super(ItemType.class);
    }
}
