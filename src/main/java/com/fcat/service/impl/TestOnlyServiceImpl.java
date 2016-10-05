package com.fcat.service.impl;

import com.fcat.data.dao.*;
import com.fcat.data.model.Image;
import com.fcat.data.model.Item;
import com.fcat.data.model.ItemSubtype;
import com.fcat.data.model.ItemType;
import com.fcat.service.ImageService;
import com.fcat.service.TestOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.out;

@Service
public class TestOnlyServiceImpl implements TestOnlyService {
    @Autowired
    ItemTypeDao itemTypeDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    ItemPropertyDao itemPropertyDao;
    @Autowired
    GroupPropertyDao groupPropertyDao;
    @Autowired
    ComponentDao componentDao;
    @Autowired
    ImageService imageService;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ItemSubtypeDao subtypeDao;

    @Override
    public void generate() {
        Item item = new Item();
        item.setLabel("Клинок");
        item.setDescription("Дешевый клинок из стали");
        Image image = new Image();
        image.setUrl("http://3d-modeli.net/uploads/posts/2015-07/1438173810_3d-model-klinok-s-runami-1.jpg");
        imageDao.save(image);
        item.setImage(image);
        ItemType type = new ItemType();
        type.setLabel("Оружие");
        ItemSubtype subtype = new ItemSubtype();
        subtype.setLabel("Клинки");
        type.addSubtype(subtype);
        //subtypeDao.save(subtype);
        //itemTypeDao.save(type);
        item.setSubtype(subtype);
        item.setImage(image);
        itemDao.save(item);
        List<Item> items = itemDao.list();
        items.forEach(out::println);
        int g = 5;
    }
}
