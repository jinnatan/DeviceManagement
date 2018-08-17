package com.jt.devicemanagement.user.api;

import com.jt.devicemanagement.device.api.BaseDeviceDTO;

import java.util.List;

public class UserDTO extends BaseUserDTO{

    private List<BaseDeviceDTO> baseDevices;

    public List<BaseDeviceDTO> getBaseDevices() {
        return baseDevices;
    }

    public void setBaseDevices(final List<BaseDeviceDTO> baseDevices) {
        this.baseDevices = baseDevices;
    }
}
