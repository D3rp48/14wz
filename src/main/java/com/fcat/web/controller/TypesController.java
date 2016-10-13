package com.fcat.web.controller;

import com.fcat.data.dao.ItemTypeDao;
import com.fcat.data.model.ItemSubtype;
import com.fcat.data.model.ItemType;
import com.fcat.web.bean.forms.ItemTypeForm;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class TypesController {
    @Autowired
    ItemTypeDao itemTypeDao;

    @RequestMapping("/types")
    public String index(Model model,
                        @RequestParam(value = "selected", required = false) String sel,
                        @RequestParam(value = "op", required = false) String op) {
        List<ItemType> itemTypes = itemTypeDao.list();
        ItemTypeForm form = new ItemTypeForm(itemTypes);
        if (!Strings.isNullOrEmpty(sel)) {
            int selected = -1;
            try {
                selected = Integer.parseInt(sel);
            } catch (Exception e) {
            }
            ;

            if (selected >= itemTypes.size() || selected < 0) {
                form.setSubtypes(null);
                form.setSelectedType(null);
            } else {
                ItemType type = itemTypes.get(selected);
                List<ItemSubtype> subtypes = type.getSubtypes();
                form.setSubtypes(subtypes);
                form.setSelectedType(selected);
            }
        }
        model.addAttribute("types", form);
        return "fragments/_types";
    }

    @RequestMapping("types/update")
    public void update() {

    }
}

