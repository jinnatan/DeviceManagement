package com.jt.devicemanagement.controllers;

import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
import com.jt.devicemanagement.services.DeviceModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(DeviceModelController.BASE_URL)
public class DeviceModelController {

    public static final String BASE_URL="/api/vi/deviceModels";

    private DeviceModelService deviceModelService;


    public DeviceModelController(final DeviceModelService deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeviceModelDTO> getDeviceModels(){
        return  deviceModelService.getAllDeviceModels();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceModelDTO getDeviceModelById(@PathVariable Long id){
        return deviceModelService.getDeviceModelById(id);
    }





}
