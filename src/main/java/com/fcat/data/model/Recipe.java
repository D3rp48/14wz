package com.fcat.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String label;
    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;
    @Transient
    private List<Component> components;
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    public void setId(int id) {
        this.id = id;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getLabel(), recipe.getLabel()) &&
                Objects.equals(getItem(), recipe.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getItem());
    }
}
