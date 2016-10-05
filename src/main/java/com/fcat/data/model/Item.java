package com.fcat.data.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String label;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "itemSubtypeId")
    private ItemSubtype subtype;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "imageId")
    private Image image;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Set<ItemProperty> itemProperties = new LinkedHashSet<>();

    public void setId(int id) {
        this.id = id;
    }

    public ItemSubtype getSubtype() {
        return subtype;
    }

    public void setSubtype(ItemSubtype subtype) {
        this.subtype = subtype;
    }

    public Set<ItemProperty> getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(Set<ItemProperty> itemProperties) {
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
                Objects.equals(getSubtype(), item.getSubtype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getSubtype());
    }
}
