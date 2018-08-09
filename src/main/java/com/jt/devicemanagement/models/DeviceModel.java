package com.jt.devicemanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private OS os;

    @NotEmpty
    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(final OS os) {
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceModel)) return false;
        final DeviceModel deviceModel = (DeviceModel) o;
        return getId() == deviceModel.getId() &&
                getOs() == deviceModel.getOs() &&
                Objects.equals(getName(), deviceModel.getName()) &&
                Objects.equals(getDescription(), deviceModel.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOs(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "id=" + id +
                ", os=" + os +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
