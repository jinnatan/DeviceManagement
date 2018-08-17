package com.jt.devicemanagement.user.services;

import com.jt.devicemanagement.exceptions.EntityNotFoundException;
import com.jt.devicemanagement.user.UserRepository;
import com.jt.devicemanagement.user.api.UserDTO;
import com.jt.devicemanagement.user.api.UserMapper;
import com.jt.devicemanagement.user.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::UserTOUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(final Long id) {
        Optional<User>  user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.UserTOUserDTO(user.get());
        } else {
            throw new EntityNotFoundException("Can't find user " + id);
        }
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {
        return saveAndReturnUserDTO(userMapper.UserDTOToUser(userDTO));
    }

    private UserDTO saveAndReturnUserDTO(User user) {
        User saved= userRepository.save(user);
        return userMapper.UserTOUserDTO(saved);
    }

    @Override
    public UserDTO updateUser(final Long id, final UserDTO userDTO) {
        User user = userMapper.UserDTOToUser(userDTO);
        user.setId(id);
        return saveAndReturnUserDTO(userMapper.UserDTOToUser(userDTO));
    }

    @Override
    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserByDeviceSerialNumber(final String serialNumber) {
        Optional<User>  user = userRepository.getUserByDeviceSerialNumber(serialNumber);
        if (user.isPresent()) {
            return userMapper.UserTOUserDTO(user.get());
        } else {
            throw new EntityNotFoundException("Can't find user with device serial number" + serialNumber);
        }
    }
}
