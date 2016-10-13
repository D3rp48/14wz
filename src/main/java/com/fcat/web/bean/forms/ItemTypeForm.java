package com.fcat.web.bean.forms;

import com.fcat.data.model.ItemSubtype;
import com.fcat.data.model.ItemType;

import java.util.List;
import java.util.Set;

public class ItemTypeForm {
    List<ItemType> itemTypeList;
    List<ItemSubtype> subtypes;
    Integer selectedType;

    public List<ItemSubtype> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<ItemSubtype> subtypes) {
        this.subtypes = subtypes;
    }

    public ItemTypeForm(List<ItemType> itemTypeList) {
        this.itemTypeList = itemTypeList;
    }

    public List<ItemType> getItemTypeList() {
        return itemTypeList;
    }

    public void setItemTypeList(List<ItemType> itemTypeList) {
        this.itemTypeList = itemTypeList;
    }

    public Integer getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(Integer selectedType) {
        this.selectedType = selectedType;
    }
}
