package com.jt.devicemanagement.device;

import com.jt.devicemanagement.device.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query("select d from Device d where d.deviceModel.id = ?1")
    List<Device> getDevicesByModelId(Long modelId);
}
