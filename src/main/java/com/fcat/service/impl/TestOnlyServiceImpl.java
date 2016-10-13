package com.fcat.service.impl;

import com.fcat.data.dao.*;
import com.fcat.data.model.*;
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
    PropertyGroupDao propertiesGroupDao;
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    ItemPropertyDao itemPropertyDao;
    @Autowired
    PropertyKeyDao propertyKeyDao;
    @Autowired
    ComponentDao componentDao;
    @Autowired
    ImageService imageService;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ItemSubtypeDao subtypeDao;

    Item item1, item2;
    PropertyGroup group, group1;
    PropertyKey key1, key2, key3, key4;
    ItemType itemType;
    ItemSubtype itemSubtype1, itemSubtype2;
    Image image1, image2, image3;
    Recipe recipe;
    Component component;
    ItemProperty property1, property2, property3, property4;

    @Override
    public void generate() {
        item1 = new Item();
        item1.setLabel("Клинок боли");
        item2 = new Item();
        item2.setLabel("Лучшая броня");
        group = new PropertyGroup();
        group.setLabel("Атака");
        group1 = new PropertyGroup();
        group1.setLabel("Защита");
        key1 = new PropertyKey();
        key2 = new PropertyKey();
        key1.setLabel("Рубящая атака");
        key2.setLabel("Критическая атака");
        key1.setPropertyGroup(group);
        key2.setPropertyGroup(group);
        key3 = new PropertyKey();
        key4 = new PropertyKey();
        key3.setLabel("Броня");
        key4.setLabel("Уклонение");
        key3.setPropertyGroup(group1);
        key4.setPropertyGroup(group1);
        itemType = new ItemType();
        itemType.setLabel("Обычные предметы");
        itemSubtype1 = new ItemSubtype();
        itemSubtype1.setLabel("Деревянные клинки");
        itemSubtype2 = new ItemSubtype();
        itemSubtype2.setLabel("Кожанная броня");
        itemSubtype2.setItemType(itemType);
        itemSubtype1.setItemType(itemType);
        itemType.getSubtypes().add(itemSubtype1);
        itemType.getSubtypes().add(itemSubtype2);
        item1.setSubtype(itemSubtype1);
        item2.setSubtype(itemSubtype2);
        property1 = new ItemProperty();
        property2 = new ItemProperty();
        property3 = new ItemProperty();
        property4 = new ItemProperty();
        property1.setPropertyKey(key1);
        property2.setPropertyKey(key2);
        property3.setPropertyKey(key3);
        property4.setPropertyKey(key4);
        property1.setValue("2");
        property2.setValue("10");
        property3.setValue("50");
        property4.setValue("666");
        property1.setItem(item1);
        property2.setItem(item1);
        property3.setItem(item2);
        property4.setItem(item2);
        item1.getItemProperties().add(property1);
        item1.getItemProperties().add(property2);
        item2.getItemProperties().add(property3);
        item2.getItemProperties().add(property4);
        recipe = new Recipe(item1);
        item1.setRecipe(recipe);
        recipe.setLabel("Рецепт клинков");
        recipe.setItem(item1);
        component = new Component();
        component.setItem(item2);
        component.setAmount(2);
        recipe.getComponents().add(component);
        recipeDao.save(recipe);
        component.setAmount(5);
        componentDao.save(component);
        component.setAmount(10);
        recipeDao.save(recipe);
        int g = 5;
    }
}
