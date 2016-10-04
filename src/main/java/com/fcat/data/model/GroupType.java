package com.fcat.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class GroupType implements Serializable {
    @Id
    private String label;
    private int priority;
    @Transient
    private List<GroupProperty> properties;

    public List<GroupProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<GroupProperty> properties) {
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
