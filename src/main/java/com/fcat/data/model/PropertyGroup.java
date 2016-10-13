package com.fcat.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class PropertyGroup implements Serializable {
    @Id
    private String label;
    private int priority;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "propertykey"})

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Set<PropertyKey> properties = new LinkedHashSet<>();

    public Set<PropertyKey> getProperties() {
        return properties;
    }

    public void setProperties(Set<PropertyKey> properties) {
        this.properties = properties;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyGroup propertyGroup = (PropertyGroup) o;
        return Objects.equals(getLabel(), propertyGroup.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }
}
