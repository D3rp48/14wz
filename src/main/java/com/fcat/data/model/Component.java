package com.fcat.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Component implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Item item;
    private int amount;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "component"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Recipe recipe;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Component> alternatives = new LinkedHashSet<>();

    public void addAlternative(Component component) {
        alternatives.add(component);
    }

    public void removeAlternative(Component component) {
        alternatives.remove(component);
    }
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

    public Set<Component> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Set<Component> alternatives) {
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
