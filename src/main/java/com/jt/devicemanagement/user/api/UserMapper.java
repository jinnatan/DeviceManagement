package com.jt.devicemanagement.user.api;

import com.jt.devicemanagement.user.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "devices", target = "baseDevices")
    UserDTO UserTOUserDTO(User user);

    @Mapping(source = "baseDevices", target = "devices")
    User UserDTOToUser(UserDTO userDTO);

}
