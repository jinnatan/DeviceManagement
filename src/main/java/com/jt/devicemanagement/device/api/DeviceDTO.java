package com.jt.devicemanagement.device.api;

import com.jt.devicemanagement.deviceModel.api.BaseDeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.user.api.BaseUserDTO;

public class DeviceDTO extends BaseDeviceDTO {

    private BaseDeviceModelDTO baseModel;
    private BaseUserDTO baseUser;

    public BaseDeviceModelDTO getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(final BaseDeviceModelDTO baseModel) {
        this.baseModel = baseModel;
    }

    public BaseUserDTO getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(final BaseUserDTO baseUser) {
        this.baseUser = baseUser;
    }
}
