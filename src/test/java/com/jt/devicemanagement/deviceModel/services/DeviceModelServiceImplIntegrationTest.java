package com.jt.devicemanagement.deviceModel.services;

import com.jt.devicemanagement.deviceModel.DeviceModelRepository;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.api.DeviceModelMapper;
import com.jt.devicemanagement.deviceModel.models.OS;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeviceModelServiceImplIntegrationTest {
    @Autowired
    DeviceModelRepository deviceModelRepository;


    private DeviceModelService deviceModelService;

    @Before
    public void setUp() {
        deviceModelService = new DeviceModelServiceImpl(deviceModelRepository, DeviceModelMapper.INSTANCE);
    }

    @Test
    public void createDeviceModel() {
        final String desc = "Desc";
        final String name = "Name";
        final long id = 1L;
        DeviceModelDTO deviceModelDTO = new DeviceModelDTO();
        deviceModelDTO.setId(1L);
        deviceModelDTO.setOs(OS.ANDROID);
        deviceModelDTO.setDescription(desc);
        deviceModelDTO.setName(name);
        deviceModelService.createDeviceModel(deviceModelDTO);

        DeviceModelDTO updatedDeviceModelDTO = deviceModelService.getDeviceModelById(id);

        assertEquals(desc, updatedDeviceModelDTO.getDescription());
        assertEquals(name, updatedDeviceModelDTO.getName());
        assertEquals(OS.ANDROID, updatedDeviceModelDTO.getOs());

    }

    @Test
    public void updateDeviceModel() {
        final long id = 2L;
        DeviceModelDTO deviceModelDTO = new DeviceModelDTO();
        deviceModelDTO.setOs(OS.IOS);
        deviceModelDTO.setDescription("Desc");
        deviceModelDTO.setName("Name");
        deviceModelDTO.setId(id);
        deviceModelService.createDeviceModel(deviceModelDTO);

        final String updatedDesc = "Updated Desc";
        final String updatedName = "Updated Name";
        deviceModelDTO.setOs(OS.ANDROID);
        deviceModelDTO.setDescription(updatedDesc);
        deviceModelDTO.setName(updatedName);


        deviceModelService.updateDeviceModel(id, deviceModelDTO);
        DeviceModelDTO updatedDeviceModelDTO = deviceModelService.getDeviceModelById(id);

                assertEquals(updatedDesc, updatedDeviceModelDTO.getDescription());
        assertEquals(updatedName, updatedDeviceModelDTO.getName());
        assertEquals(OS.ANDROID, updatedDeviceModelDTO.getOs());

    }



}