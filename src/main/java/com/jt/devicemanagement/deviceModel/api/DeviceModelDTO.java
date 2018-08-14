package com.jt.devicemanagement.deviceModel.api;

import com.jt.devicemanagement.device.api.BaseDeviceDTO;
import com.jt.devicemanagement.deviceModel.models.OS;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class DeviceModelDTO extends BaseDeviceModelDTO {

    private List<BaseDeviceDTO> baseDevices;

    public List<BaseDeviceDTO> getBaseDevices() {
        return baseDevices;
    }

    public void setBaseDevices(final List<BaseDeviceDTO> baseDevices) {
        this.baseDevices = baseDevices;
    }

   }
