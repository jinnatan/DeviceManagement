package com.jt.devicemanagement.deviceModel.api;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceModelMapper {

    DeviceModelMapper INSTANCE = Mappers.getMapper(DeviceModelMapper.class);

    DeviceModelDTO DeviceModelToDeviceModelDTO(DeviceModel deviceModel);

    DeviceModel DeviceModelDTOToDeviceModel(DeviceModelDTO deviceModelDTO);

}

