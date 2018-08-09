package com.jt.devicemanagement.repositories;

import com.jt.devicemanagement.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, Long> {
}
