package com.jt.devicemanagement.api.mappers;

import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
import com.jt.devicemanagement.models.DeviceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceModelMapper {

    DeviceModelMapper INSTANCE = Mappers.getMapper(DeviceModelMapper.class);

    DeviceModelDTO DeviceModelToDeviceModelDTO(DeviceModel deviceModel);

    DeviceModel DeviceModelDTOToDeviceModel(DeviceModelDTO deviceModelDTO);

}

