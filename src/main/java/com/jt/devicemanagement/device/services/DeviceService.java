package com.jt.devicemanagement.device.services;

import com.jt.devicemanagement.device.api.DeviceDTO;

import java.util.List;

public interface DeviceService {
    List<DeviceDTO> getAllDevices();
    DeviceDTO getDeviceBySerialNumber(String serialNumber);
    DeviceDTO getDeviceByModelId(Long id);
    DeviceDTO createDevice(DeviceDTO deviceDTO);
    DeviceDTO updateDevice(String serialNumber, DeviceDTO deviceDTO);
    void deleteDevice(String serialNumber);
}
