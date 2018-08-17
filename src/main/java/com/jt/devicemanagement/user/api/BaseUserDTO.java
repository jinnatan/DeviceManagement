package com.jt.devicemanagement.user.api;

import com.jt.devicemanagement.device.api.BaseDeviceDTO;
import com.jt.devicemanagement.device.models.Device;


import java.util.List;

public class BaseUserDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
