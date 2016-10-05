package com.fcat.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class GroupType implements Serializable {
    @Id
    private String label;
    private int priority;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Set<GroupProperty> properties = new LinkedHashSet<>();

    public Set<GroupProperty> getProperties() {
        return properties;
    }

    public void setProperties(Set<GroupProperty> properties) {
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
        GroupType groupType = (GroupType) o;
        return Objects.equals(getLabel(), groupType.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }
}
