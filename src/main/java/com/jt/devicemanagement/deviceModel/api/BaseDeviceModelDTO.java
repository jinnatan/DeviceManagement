package com.jt.devicemanagement.deviceModel.api;

import com.jt.devicemanagement.deviceModel.models.OS;
import io.swagger.annotations.ApiModelProperty;

public class BaseDeviceModelDTO {
    private Long id;

    @ApiModelProperty(required = true)
    private OS os;

    @ApiModelProperty(required = true)
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
