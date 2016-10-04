package com.fcat.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Component implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Item item;
    private int amount;
    private Recipe recipe;
    @Transient
    private List<Component> alternatives;

    public void setId(int id) {
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Component> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Component> alternatives) {
        this.alternatives = alternatives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return getAmount() == component.getAmount() &&
                Objects.equals(getItem(), component.getItem()) &&
                Objects.equals(getRecipe(), component.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem(), getAmount(), getRecipe());
    }
}
