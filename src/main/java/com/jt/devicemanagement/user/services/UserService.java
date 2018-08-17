package com.jt.devicemanagement.user.services;

import com.jt.devicemanagement.user.api.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO getUserByDeviceSerialNumber(String serialNumber);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser( Long id, UserDTO userDTO);
    void deleteUser(Long id);


}
