package com.fcat.data.dao.impl;

import com.fcat.data.dao.ItemDao;
import com.fcat.data.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item, Integer> implements ItemDao {
    public ItemDaoImpl() {
        super(Item.class);
    }
}
