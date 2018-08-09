package com.jt.devicemanagement.api.DTOs;

import com.jt.devicemanagement.models.OS;

public class DeviceModelDTO {
    private Long id;

    private OS os;
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
}
