package com.jt.devicemanagement.services;

import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
import com.jt.devicemanagement.models.DeviceModel;

import java.util.List;

public interface DeviceModelService {

    List<DeviceModelDTO> getAllDeviceModels();

    DeviceModelDTO getDeviceModelById(Long id);
}
