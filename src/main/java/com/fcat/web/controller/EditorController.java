package com.fcat.web.controller;

import com.fcat.data.dao.*;
import com.fcat.data.model.*;
import com.fcat.service.ImageService;
import com.fcat.web.bean.*;
import com.fcat.web.bean.forms.ImageUploadForm;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
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
    RecipeDao recipeDao;
    @Autowired
    ItemPropertyDao itemPropertyDao;
    @Autowired
    GroupPropertyDao groupPropertyDao;
    @Autowired
    ComponentDao componentDao;
    @Autowired
    ImageService imageService;


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
        List<Image> images = imageService.findByExpressionsPaged(rows, page);
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

    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/images/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse imagesEdit(ImageUploadForm form, @RequestParam("op") String param) {

        switch (param) {
            case "add":
            case "edit": {
                imageService.uploadImage(form.getFile(),
                        form.getLabel(),
                        form.getCaption(),
                        form.getTag());
            }
            case "delete": {
                imageService.removeImage(form.getFile());
            }
        }
        return new JsonResponse(true, "ok");
    }


    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
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
