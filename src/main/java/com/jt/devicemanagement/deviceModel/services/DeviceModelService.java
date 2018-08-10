package com.jt.devicemanagement.deviceModel.services;

import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;

import java.util.List;

public interface DeviceModelService {

    List<DeviceModelDTO> getAllDeviceModels();

    DeviceModelDTO getDeviceModelById(Long id);

    DeviceModelDTO createDeviceModel(DeviceModelDTO deviceModelDTO);

    DeviceModelDTO updateDeviceModel(Long id, DeviceModelDTO deviceModelDTO);

    void deleteDeviceModel(Long id);

}
