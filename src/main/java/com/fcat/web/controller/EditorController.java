package com.fcat.web.controller;

import com.fcat.data.dao.*;
import com.fcat.data.model.*;
import com.fcat.web.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EditorController {
    @Autowired
    ItemTypeDao itemTypeDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    ItemPropertyDao itemPropertyDao;
    @Autowired
    GroupPropertyDao groupPropertyDao;
    @Autowired
    ComponentDao componentDao;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public
    @ResponseBody
    JqGridBean items(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        List<Item> items = itemDao.findByExpressionsPaged(rows, page);
        int count = items.size();
        JqGridBean<Item> jqGridBean = new JqGridBean<>();
        jqGridBean.setTotal((int) (count - 1) / rows + 1);
        jqGridBean.setPage(page.toString());
        jqGridBean.setRecords(Long.toString(count));
        jqGridBean.setRows(items);
        return jqGridBean;
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public
    @ResponseBody
    JqGridBean groups(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        List<GroupType> groups = groupDao.findByExpressionsPaged(rows, page);
        int count = groups.size();
        JqGridBean<GroupType> jqGridBean = new JqGridBean<>();
        jqGridBean.setTotal((int) (count - 1) / rows + 1);
        jqGridBean.setPage(page.toString());
        jqGridBean.setRecords(Long.toString(count));
        jqGridBean.setRows(groups);
        return jqGridBean;
    }

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public
    @ResponseBody
    JqGridBean images(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        List<Image> images = imageDao.findByExpressionsPaged(rows, page);
        int count = images.size();
        JqGridBean<Image> jqGridBean = new JqGridBean<>();
        jqGridBean.setTotal((int) (count - 1) / rows + 1);
        jqGridBean.setPage(page.toString());
        jqGridBean.setRecords(Long.toString(count));
        jqGridBean.setRows(images);
        return jqGridBean;
    }

    @RequestMapping(value = "/itemtypes", method = RequestMethod.GET)
    public
    @ResponseBody
    JqGridBean itemTypes(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        List<ItemType> itemtypes = itemTypeDao.findByExpressionsPaged(rows, page);
        int count = itemtypes.size();
        JqGridBean<ItemType> jqGridBean = new JqGridBean<>();
        jqGridBean.setTotal((int) (count - 1) / rows + 1);
        jqGridBean.setPage(page.toString());
        jqGridBean.setRecords(Long.toString(count));
        jqGridBean.setRows(itemtypes);
        return jqGridBean;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public
    @ResponseBody
    JqGridBean recipes(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        List<Recipe> recipes = recipeDao.findByExpressionsPaged(rows, page);
        int count = recipes.size();
        JqGridBean<Recipe> jqGridBean = new JqGridBean<>();
        jqGridBean.setTotal((int) (count - 1) / rows + 1);
        jqGridBean.setPage(page.toString());
        jqGridBean.setRecords(Long.toString(count));
        jqGridBean.setRows(recipes);
        return jqGridBean;
    }

    @RequestMapping(value = "/items/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse itemsEdit(Item item, @RequestParam("op") String param) {
        switch (param) {
            case "add":
            case "edit":
                itemDao.save(item);
            case "delete":
                itemDao.delete(item);
        }
        return new JsonResponse(true, "ok");
    }

    @RequestMapping(value = "/groups/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse groupsEdit(GroupType groupType, @RequestParam("op") String param) {
        switch (param) {
            case "add":
            case "edit":
                groupDao.save(groupType);
            case "delete":
                groupDao.delete(groupType);
        }
        return new JsonResponse(true, "ok");
    }

    @RequestMapping(value = "/images/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse imagesEdit(Image image, @RequestParam("op") String param) {
        switch (param) {
            case "add":
            case "edit":
                imageDao.save(image);
            case "delete":
                imageDao.delete(image);
        }
        return new JsonResponse(true, "ok");
    }

    @RequestMapping(value = "/itemtypes/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse itemTypesEdit(ItemType itemType, @RequestParam("op") String param) {
        switch (param) {
            case "add":
            case "edit":
                itemTypeDao.save(itemType);
            case "delete":
                itemTypeDao.delete(itemType);
        }
        return new JsonResponse(true, "ok");
    }

    @RequestMapping(value = "/recipes/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse recipesEdit(Recipe recipe, @RequestParam("op") String param) {
        switch (param) {
            case "add":
            case "edit":
                recipeDao.save(recipe);
            case "delete":
                recipeDao.delete(recipe);
        }
        return new JsonResponse(true, "ok");
    }


}
