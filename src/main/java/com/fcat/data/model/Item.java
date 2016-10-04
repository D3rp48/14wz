package com.fcat.data.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String label;
    private String description;
    @ManyToOne
    @JoinColumn(name = "itemTypeId")
    private ItemType type;
    @ManyToOne
    @JoinColumn(name = "itemSubtypeId")
    private ItemSubtype subtype;

    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;
    @Transient
    private List<ItemProperty> itemProperties;

    public void setId(int id) {
        this.id = id;
    }

    public ItemSubtype getSubtype() {
        return subtype;
    }

    public void setSubtype(ItemSubtype subtype) {
        this.subtype = subtype;
    }

    public List<ItemProperty> getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(List<ItemProperty> itemProperties) {
        this.itemProperties = itemProperties;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(getLabel(), item.getLabel()) &&
                Objects.equals(getType(), item.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getType());
    }
}
