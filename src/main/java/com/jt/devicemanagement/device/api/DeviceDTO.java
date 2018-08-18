package com.jt.devicemanagement.device.api;

import com.jt.devicemanagement.deviceModel.api.BaseDeviceModelDTO;
import com.jt.devicemanagement.user.api.BaseUserDTO;

public class DeviceDTO extends BaseDeviceDTO {

    private BaseDeviceModelDTO model;
    private BaseUserDTO user;

    public BaseDeviceModelDTO getModel() {
        return model;
    }

    public void setModel(final BaseDeviceModelDTO model) {
        this.model = model;
    }

    public BaseUserDTO getUser() {
        return user;
    }

    public void setUser(final BaseUserDTO user) {
        this.user = user;
    }
}
