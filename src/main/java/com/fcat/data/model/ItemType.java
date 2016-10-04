package com.fcat.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class ItemType implements Serializable {
    @Id
    private String label;
    private String description;
    @Transient
    private List<Item> Items;

    String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
        return Objects.equals(getLabel(), itemType.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }
}