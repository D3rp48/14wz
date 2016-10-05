package com.fcat.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "itemId")
    private Item item;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "groupPropertyId")
    private GroupProperty property;
    private String value;

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return property.getLabel();
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public GroupProperty getProperty() {
        return property;
    }

    public void setProperty(GroupProperty property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemProperty that = (ItemProperty) o;
        return Objects.equals(getItem(), that.getItem()) &&
                Objects.equals(getProperty(), that.getProperty()) &&
                Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem(), getProperty(), getValue());
    }
}
