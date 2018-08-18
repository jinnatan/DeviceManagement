package com.jt.devicemanagement.user.api;

import com.jt.devicemanagement.user.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO UserTOUserDTO(User user);

    User UserDTOToUser(UserDTO userDTO);

}
