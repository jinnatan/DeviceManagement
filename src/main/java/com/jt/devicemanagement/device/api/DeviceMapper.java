package com.jt.devicemanagement.device.api;


import com.jt.devicemanagement.device.models.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);


    @Mapping(source = "deviceModel", target = "baseModel")
    @Mapping(source = "user", target = "baseUser")
    DeviceDTO DeviceToDeviceDTO(Device device);


    @Mapping(source = "baseModel", target = "deviceModel")
    @Mapping(source = "baseUser", target = "user")
    Device DeviceDTOToDevice(DeviceDTO deviceDTO);



}
