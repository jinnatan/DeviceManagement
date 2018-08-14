package com.jt.devicemanagement.device;

import com.jt.devicemanagement.device.api.DeviceDTO;
import com.jt.devicemanagement.device.services.DeviceService;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Device Controller API")
@RestController
@RequestMapping(DeviceController.BASE_URL)
public class DeviceController {
    public static final String BASE_URL="/api/v1/devices";

    private DeviceService deviceService;

    public DeviceController(final DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @ApiOperation(value = "Get all Devices")
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<DeviceDTO> getAllDevices(){
        return deviceService.getAllDevices();
    }


    @ApiOperation(value = "Get device by Serial Number")
    @GetMapping("{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceDTO getDeviceBySerialNumber(@PathVariable String serialNumber){
        return deviceService.getDeviceBySerialNumber(serialNumber);
    }

    @ApiOperation(value = "Get devices by Model ID")
    @GetMapping("/modelId/{modelId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<DeviceDTO> getDeviceByModelId(@PathVariable Long modelId){
        return deviceService.getDevicesByModelId(modelId);
    }

    @ApiOperation(value = "Create Device")
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return deviceService.createDevice(deviceDTO);
    }

    @ApiOperation(value = "Update device")
    @PutMapping("{serialNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public DeviceDTO updateDevice(@PathVariable String serialNumber, @RequestBody DeviceDTO deviceDTO){
        return deviceService.updateDevice(serialNumber, deviceDTO);
    }




}


