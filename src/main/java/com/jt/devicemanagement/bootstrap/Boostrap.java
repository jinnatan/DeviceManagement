package com.jt.devicemanagement.bootstrap;

import com.jt.devicemanagement.device.DeviceRepository;
import com.jt.devicemanagement.device.models.Device;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.deviceModel.models.OS;
import com.jt.devicemanagement.deviceModel.DeviceModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Boostrap implements CommandLineRunner {

    private final DeviceModelRepository deviceModelRepository;
    private final DeviceRepository deviceRepository;

    public Boostrap(final DeviceModelRepository deviceModelRepository, final DeviceRepository deviceRepository) {
        this.deviceModelRepository = deviceModelRepository;
        this.deviceRepository = deviceRepository;
    }


    @Override
    public void run(final String... args) throws Exception {
        loadDeviceModels();

    }

    private void loadDeviceModels() {
        DeviceModel deviceModel1 = new DeviceModel();
        deviceModel1.setOs(OS.ANDROID);
        deviceModel1.setDescription("Samsung Galaxy 9");
        deviceModel1.setName("AND1");


        Device device1 = new Device();
        device1.setAssetNumber("SAP123");
        device1.setName("DEV1");
        device1.setSerialNumber("afdsf-afdasf-qrew");
        device1.setDeviceModel(deviceModel1);

//        List<Device> devices = new ArrayList<>();
//        devices.add(device1);
//        deviceModel1.setDevices(devices);

        deviceModelRepository.save(deviceModel1);
        deviceRepository.save(device1);

        DeviceModel deviceModel2 = new DeviceModel();
        deviceModel2.setOs(OS.IOS);
        deviceModel2.setDescription("iPhone x");
        deviceModel2.setName("IPH1");


        Device device2 = new Device();
        device2.setAssetNumber("SAP234");
        device2.setName("DEV2");
        device2.setSerialNumber("afdsf-afdasf-afds");
        device2.setDeviceModel(deviceModel2);

        deviceModelRepository.save(deviceModel2);
        deviceRepository.save(device2);
    }

}
