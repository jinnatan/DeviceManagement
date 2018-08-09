package com.jt.devicemanagement.bootstrap;

import com.jt.devicemanagement.models.DeviceModel;
import com.jt.devicemanagement.models.OS;
import com.jt.devicemanagement.repositories.DeviceModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boostrap implements CommandLineRunner {

    private final DeviceModelRepository deviceModelRepository;

    public Boostrap(final DeviceModelRepository deviceModelRepository) {
        this.deviceModelRepository = deviceModelRepository;
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
        deviceModelRepository.save(deviceModel1);

        DeviceModel deviceModel2 = new DeviceModel();
        deviceModel1.setOs(OS.IOS);
        deviceModel1.setDescription("iPhone x");
        deviceModel1.setName("IPH1");
        deviceModelRepository.save(deviceModel2);
    }

}