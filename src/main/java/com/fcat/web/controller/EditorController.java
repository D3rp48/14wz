package com.fcat.web.controller;

import com.fcat.data.dao.*;
import com.fcat.data.model.*;
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
    ImageDao imageDao;
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    ItemPropertyDao itemPropertyDao;
    @Autowired
    GroupPropertyDao groupPropertyDao;
    @Autowired
    ComponentDao componentDao;

    private final static String FILE_BASE = ""; //TODO filebase
    private final static List<String> IMAGE_FORMATS = new ArrayList<String>() {{
        add("jpg");
        add("jpeg");
        add("png");
    }};

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

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/files/upload")
    public String uploadImage(ImageUploadForm form) {
        CommonsMultipartFile file = form.getFile();
        Image image = new Image();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            if (!IMAGE_FORMATS.contains(extension.toLowerCase())) {
                return null;
            }
            String fileName = FILE_BASE + "/files/" + file.getName() + "." + extension;
            File outputFile = new File(fileName);
            if (!outputFile.exists()) {
                try {
                    outputFile.getParentFile().mkdirs();
                    outputFile.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            outputStream = new FileOutputStream(outputFile);
            inputStream = new BufferedInputStream(file.getInputStream());
            byte[] buf = new byte[64 * 1024];
            int read;
            while ((read = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, read);
            }
            return extension;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        return "ok";
    }

}
