package com.jt.devicemanagement.deviceModel.services;

import com.jt.devicemanagement.deviceModel.DeviceModelRepository;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.api.DeviceModelMapper;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.deviceModel.models.OS;
import com.jt.devicemanagement.exceptions.EntityNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class DeviceModelServiceTest {

    private DeviceModelService deviceModelService;
    private DeviceModel deviceModel1;
    private DeviceModel deviceModel2;
    private DeviceModelDTO deviceModelDTO1;

    private static final String DESC1 = "Iphone 5";
    private static final long ID1 = 10;
    private static final String NAME1 = "IPH3";
    private static final OS OPER_SYS1 = OS.IOS;

    private static final String DESC2 = "Samsung 9";
    private static final long ID2 = 2;
    private static final String NAME2 = "AND2";
    private static final OS OPER_SYS2 = OS.ANDROID;

    @Mock
    private DeviceModelRepository deviceModelRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        deviceModelService = new DeviceModelServiceImpl(deviceModelRepository, DeviceModelMapper.INSTANCE);
        createTestData();
    }

    private void createTestData(){
        deviceModel1 = new DeviceModel();
        deviceModel1.setOs(OPER_SYS1);
        deviceModel1.setName(NAME1);
        deviceModel1.setId(ID1);
        deviceModel1.setDescription(DESC1);

        deviceModel2 = new DeviceModel();
        deviceModel2.setOs(OPER_SYS2);
        deviceModel2.setName(NAME2);
        deviceModel2.setId(ID2);
        deviceModel2.setDescription(DESC2);

        deviceModelDTO1 = new DeviceModelDTO();
        deviceModelDTO1.setOs(OPER_SYS1);
        deviceModelDTO1.setName(NAME1);
        deviceModelDTO1.setId(ID1);
        deviceModelDTO1.setDescription(DESC1);
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllDeviceModels() {

        List<DeviceModel> deviceModels = Arrays.asList(deviceModel1, deviceModel2 );

        Mockito.when(deviceModelRepository.findAll()).thenReturn(deviceModels);

        List<DeviceModelDTO> deviceModelDTOs = deviceModelService.getAllDeviceModels();
        assertEquals(deviceModelDTOs.size(), 2);
        assertEquals(deviceModelDTOs.get(0).getDescription(), DESC1);
        assertEquals(deviceModelDTOs.get(0).getName(), NAME1);
        assertEquals(deviceModelDTOs.get(0).getId(), Long.valueOf(ID1));
        assertEquals(deviceModelDTOs.get(0).getOs(), OPER_SYS1);

        assertEquals(deviceModelDTOs.get(1).getDescription(), DESC2);
        assertEquals(deviceModelDTOs.get(1).getName(), NAME2);
        assertEquals(deviceModelDTOs.get(1).getId(), Long.valueOf(ID2));
        assertEquals(deviceModelDTOs.get(1).getOs(), OPER_SYS2);

    }

    @Test
    public void getDeviceModelById() {
        long id = 10;
        Mockito.when(deviceModelRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(deviceModel1));
        DeviceModelDTO deviceModelDTO = deviceModelService.getDeviceModelById(id);
        assertDeviceModelDTO1(deviceModelDTO);
    }

    private void assertDeviceModelDTO1(DeviceModelDTO deviceModelDTO){
        assertEquals(deviceModelDTO.getDescription(), DESC1);
        assertEquals(deviceModelDTO.getName(), NAME1);
        assertEquals(deviceModelDTO.getId(), Long.valueOf(ID1));
        assertEquals(deviceModelDTO.getOs(), OPER_SYS1);
    }


    @Test(expected = EntityNotFoundException.class)
    public void getDeviceModelByIdNotFound() {
        long id = 10;
        Mockito.when(deviceModelRepository.findById(id)).thenReturn(Optional.empty());
        deviceModelService.getDeviceModelById(id);
    }

    @Test
    public void createDeviceModel() {
        Mockito.when(deviceModelRepository.save(deviceModel1)).thenReturn(deviceModel1);
        DeviceModelDTO deviceModelDTO= deviceModelService.createDeviceModel(deviceModelDTO1);
        assertDeviceModelDTO1(deviceModelDTO);

    }

    @Test
    public void updateDeviceModel() {
        Mockito.when(deviceModelRepository.save(deviceModel1)).thenReturn(deviceModel1);
        DeviceModelDTO deviceModelDTO= deviceModelService.updateDeviceModel(10L, deviceModelDTO1);
        assertDeviceModelDTO1(deviceModelDTO);
    }

    @Test
    public void deleteDeviceModel() {
        long id = 10;
        deviceModelService.deleteDeviceModel(id);
        then(deviceModelRepository).should(times(1)).deleteById(id);
    }
}