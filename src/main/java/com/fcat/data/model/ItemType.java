package com.fcat.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.*;

@Entity
public class ItemType implements Serializable {
    @Id
    private String label;
    private String description;
    @Transient
    private Set<ItemSubtype> subtypes;

    public ItemType() {
        subtypes = new LinkedHashSet<>();
    }

    public void addSubtype(ItemSubtype subtype) {
        subtype.setItemType(this);
        subtypes.add(subtype);
    }

    public void removeSubtype(ItemSubtype subtype) {
        if (!subtype.getItemType().equals(this))
            return;
        subtype.setItemType(null);
        subtypes.remove(subtype);
    }

    public void deleteSubtype(ItemSubtype subtype) {
        subtypes.remove(subtype);
    }

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

    public Set<ItemSubtype> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(Set<ItemSubtype> subtypes) {
        this.subtypes = subtypes;
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
