package com.jt.devicemanagement.deviceModel.api;

import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.deviceModel.models.OS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceModelMapperTest {

    private static final String DESC = "Iphone 5";
    private static final long ID = 10;
    private static final String NAME = "IPH3";
    private static final OS OPER_SYS = OS.IOS;
    DeviceModelMapper deviceModelMapper = DeviceModelMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void deviceModelToDeviceModelDTO() {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setDescription(DESC);
        deviceModel.setId(ID);
        deviceModel.setName(NAME);
        deviceModel.setOs(OPER_SYS);
        DeviceModelDTO deviceModelDTO = deviceModelMapper.DeviceModelToDeviceModelDTO(deviceModel);
        assertEquals(Long.valueOf(ID), deviceModelDTO.getId());
        assertEquals(NAME, deviceModelDTO.getName());
        assertEquals(DESC, deviceModelDTO.getDescription());
        assertEquals(OPER_SYS, deviceModelDTO.getOs());
    }

    @Test
    public void deviceModelDTOToDeviceModel() {
        DeviceModelDTO deviceModelDTO = new DeviceModelDTO();
        deviceModelDTO.setDescription(DESC);
        deviceModelDTO.setId(ID);
        deviceModelDTO.setName(NAME);
        deviceModelDTO.setOs(OPER_SYS);
        DeviceModel deviceModel = deviceModelMapper.DeviceModelDTOToDeviceModel(deviceModelDTO);
        assertEquals(Long.valueOf(ID), deviceModel.getId());
        assertEquals(NAME, deviceModel.getName());
        assertEquals(DESC, deviceModel.getDescription());
        assertEquals(OPER_SYS, deviceModel.getOs());
    }

}