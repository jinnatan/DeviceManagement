package com.jt.devicemanagement.device.api;

import com.jt.devicemanagement.deviceModel.api.BaseDeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;

public class DeviceDTO extends BaseDeviceDTO {

    private BaseDeviceModelDTO baseModel;

    public BaseDeviceModelDTO getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(final BaseDeviceModelDTO baseModel) {
        this.baseModel = baseModel;
    }
}
