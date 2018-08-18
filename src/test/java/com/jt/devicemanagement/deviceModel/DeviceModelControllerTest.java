package com.jt.devicemanagement.deviceModel;

import com.jt.devicemanagement.BaseRestControllerTest;
import com.jt.devicemanagement.TestUtil;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.OS;
import com.jt.devicemanagement.deviceModel.services.DeviceModelService;
import com.jt.devicemanagement.exceptionHandlers.GlobalResponseEntityExceptionHandler;
import com.jt.devicemanagement.exceptions.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;

public class DeviceModelControllerTest{

    @Mock
    DeviceModelService deviceModelService;

    @InjectMocks
    DeviceModelController deviceModelController;

    private MockMvc mockMvc;
    private DeviceModelDTO deviceModelDTO1;
    private DeviceModelDTO returnDeviceModelDTO1;
    final String NAME = "Iphone x";
    final String DESC = "Iphone X grey";

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(deviceModelController)
                .setControllerAdvice(new GlobalResponseEntityExceptionHandler())
                .build();
        createTestData();
    }

    private void createTestData() {
        deviceModelDTO1 = new DeviceModelDTO();
        deviceModelDTO1.setName(NAME);
        deviceModelDTO1.setDescription(DESC);
        deviceModelDTO1.setOs(OS.ANDROID);

        returnDeviceModelDTO1 = new DeviceModelDTO();
        returnDeviceModelDTO1.setName(NAME);
        returnDeviceModelDTO1.setDescription(DESC);
        returnDeviceModelDTO1.setOs(OS.ANDROID);
    }


    @Test
    public void getDeviceModelById() throws Exception {
        Mockito.when(deviceModelService.getDeviceModelById(1L)).thenReturn(returnDeviceModelDTO1);
        mockMvc.perform(get(DeviceModelController.BASE_URL+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.description", equalTo(DESC)));
    }


    @Test
    public void getDeviceModelByIdNoEntityFound() throws Exception {
        Mockito.when(deviceModelService.getDeviceModelById(1L)).thenThrow(EntityNotFoundException.class);
        mockMvc.perform(get(DeviceModelController.BASE_URL+"/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void createDeviceModel() throws Exception {
        returnDeviceModelDTO1.setId(2L);
        Mockito.when(deviceModelService.createDeviceModel(deviceModelDTO1)).thenReturn(returnDeviceModelDTO1);


        mockMvc.perform(post(DeviceModelController.BASE_URL).contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.asJsonString(deviceModelDTO1)))
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$.name", equalTo(NAME)))
//                .andExpect(jsonPath("$.description", equalTo(DESC)))
//                .andExpect(jsonPath("$.id", equalTo(2L)));

    }

    @Test
    public void updateDeviceModel() throws Exception {
        returnDeviceModelDTO1.setName("Updated" + NAME);
        returnDeviceModelDTO1.setDescription("Updated" + DESC);
        Mockito.when(deviceModelService.updateDeviceModel(1L,deviceModelDTO1)).thenReturn(returnDeviceModelDTO1);
        mockMvc.perform(put(DeviceModelController.BASE_URL+"/1").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.asJsonString(deviceModelDTO1)))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.name", equalTo("Updated" + NAME)))
//                .andExpect(jsonPath("$.description", equalTo("Updated" + DESC)));
    }

    @Test
    public void deleteDeviceModel() throws Exception {
        mockMvc.perform(delete(DeviceModelController.BASE_URL+"/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}