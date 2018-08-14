package com.jt.devicemanagement.device;

import com.jt.devicemanagement.device.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, String> {
}
