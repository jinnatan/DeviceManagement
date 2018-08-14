package com.jt.devicemanagement.device;

import com.jt.devicemanagement.device.api.DeviceDTO;
import com.jt.devicemanagement.device.services.DeviceService;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Device Controller API")
@RestController
@RequestMapping(DeviceController.BASE_URL)
public class DeviceController {
    public static final String BASE_URL="/api/vi/devices";

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

}
