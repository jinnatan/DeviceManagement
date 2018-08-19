package com.jt.devicemanagement.user;

import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.user.api.UserDTO;
import com.jt.devicemanagement.user.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("API for users")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL="/api/v1/users";

    private UserService userService;


    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Get all Users")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all user by ID")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/deivceSerialNumber/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get user by serial number")
    public UserDTO getUserById(@PathVariable String serialNumber){
        return userService.getUserByDeviceSerialNumber(serialNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update user by id")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "delete user by id")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
