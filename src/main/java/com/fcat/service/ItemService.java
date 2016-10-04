package com.fcat.service;

import com.fcat.data.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();

    List<Item> search(String name);

    void create(Item item);

    void update(Item item);

    void delete(Item item);
}
