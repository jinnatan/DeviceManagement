package com.jt.devicemanagement.deviceModel;

import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.services.DeviceModelService;
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

@RestController
@RequestMapping(DeviceModelController.BASE_URL)
@Api(description = "Device models API")
public class DeviceModelController {

    public static final String BASE_URL="/api/v1/deviceModels";

    private DeviceModelService deviceModelService;


    public DeviceModelController(final DeviceModelService deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all device models")
    public List<DeviceModelDTO> getDeviceModels(){
        return  deviceModelService.getAllDeviceModels();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all device model by ID")
    public DeviceModelDTO getDeviceModelById(@PathVariable Long id){
        return deviceModelService.getDeviceModelById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create device model")
    public DeviceModelDTO createDeviceModel(@RequestBody DeviceModelDTO deviceModel) {
        return deviceModelService.createDeviceModel(deviceModel);

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update device model by id")
    public DeviceModelDTO updateDeviceModel(@PathVariable Long id, @RequestBody DeviceModelDTO deviceModelDTO){
        return deviceModelService.updateDeviceModel(id, deviceModelDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "delete device model by id")
    public void deleteDeviceModel(@PathVariable Long id){
        deviceModelService.deleteDeviceModel(id);
    }








}
