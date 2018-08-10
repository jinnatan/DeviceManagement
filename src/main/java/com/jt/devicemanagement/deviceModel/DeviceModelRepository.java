package com.jt.devicemanagement.deviceModel;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, Long> {
}
