package com.jt.devicemanagement.device.api;


import com.jt.devicemanagement.device.models.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);


    @Mapping(source = "deviceModel", target = "model")
    DeviceDTO DeviceToDeviceDTO(Device device);


    @Mapping(source = "model", target = "deviceModel")
    Device DeviceDTOToDevice(DeviceDTO deviceDTO);



}
