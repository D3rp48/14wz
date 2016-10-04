package com.fcat.data.dao.impl;

import com.fcat.data.dao.ItemSubtypeDao;
import com.fcat.data.model.ItemSubtype;
import org.springframework.stereotype.Repository;

@Repository
public class ItemSubtypeDaoImpl extends GenericDaoImpl<ItemSubtype, Integer> implements ItemSubtypeDao {
    public ItemSubtypeDaoImpl() {
        super(ItemSubtype.class);
    }
}
