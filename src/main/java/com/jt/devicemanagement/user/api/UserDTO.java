package com.jt.devicemanagement.user.api;

import com.jt.devicemanagement.device.api.BaseDeviceDTO;

import java.util.List;

public class UserDTO extends BaseUserDTO{

    private List<BaseDeviceDTO> devices;

    public List<BaseDeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(final List<BaseDeviceDTO> devices) {
        this.devices = devices;
    }
}
