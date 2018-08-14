package com.jt.devicemanagement.device.models;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {


    @Id
    private String serialNumber;

    @ApiModelProperty(value = "Asset Number")
    private String assetNumber;

    @ApiModelProperty(value = "Name")
    private String name;


    @ManyToOne
    private DeviceModel deviceModel;


    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(final String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public DeviceModel getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(final DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }
}
