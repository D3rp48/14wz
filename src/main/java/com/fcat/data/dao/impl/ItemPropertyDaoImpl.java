package com.fcat.data.dao.impl;

import com.fcat.data.dao.ItemPropertyDao;
import com.fcat.data.model.ItemProperty;
import org.springframework.stereotype.Repository;

@Repository
public class ItemPropertyDaoImpl extends GenericDaoImpl<ItemProperty, Integer> implements ItemPropertyDao {
    public ItemPropertyDaoImpl() {
        super(ItemProperty.class);
    }
}
