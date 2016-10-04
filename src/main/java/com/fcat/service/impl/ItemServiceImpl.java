package com.fcat.service.impl;

import com.fcat.data.dao.ItemDao;
import com.fcat.data.dao.impl.ItemDaoImpl;
import com.fcat.data.model.Item;
import com.fcat.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> getAll() {
        return itemDao.list();
    }

    @Override
    public List<Item> search(String name) {
        String n = name.toLowerCase();
        return itemDao
                .list()
                .stream()
                .filter(x -> x.getLabel().toLowerCase().contains(n))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Item item) {

    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(Item item) {

    }
}
