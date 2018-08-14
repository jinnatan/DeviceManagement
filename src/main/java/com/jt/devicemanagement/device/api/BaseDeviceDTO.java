package com.jt.devicemanagement.device.api;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;

public class BaseDeviceDTO {
    private String serialNumber;

    private String assetNumber;
    private String name;


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(final String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
