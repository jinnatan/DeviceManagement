package com.jt.devicemanagement.deviceModel.api;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceModelMapper {

    DeviceModelMapper INSTANCE = Mappers.getMapper(DeviceModelMapper.class);

    @Mapping(source = "devices", target = "baseDevices")
    DeviceModelDTO DeviceModelToDeviceModelDTO(DeviceModel deviceModel);

    @Mapping(source = "baseDevices", target = "devices")
    DeviceModel DeviceModelDTOToDeviceModel(DeviceModelDTO deviceModelDTO);

}

