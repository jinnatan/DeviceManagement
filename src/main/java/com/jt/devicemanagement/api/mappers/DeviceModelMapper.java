package com.jt.devicemanagement.api.mappers;

import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
import com.jt.devicemanagement.models.DeviceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceModelMapper {

    DeviceModelMapper INSTANCE = Mappers.getMapper(DeviceModelMapper.class);

    DeviceModelDTO DeviceModelToDeviceModelDTO(DeviceModel deviceModel);

}


//import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
//import com.jt.devicemanagement.models.DeviceModel;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
///**
// * Created by jt on 9/25/17.
// */
//@Mapper
//public interface DeviceModelMapper {
//
//    DeviceModelMapper INSTANCE = Mappers.getMapper(DeviceModelMapper.class);
//
//
//    DeviceModelDTO DeviceModelToDeviceModelDTO(DeviceModel deviceModel);
//}
