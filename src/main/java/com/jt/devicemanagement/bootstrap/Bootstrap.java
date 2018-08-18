package com.jt.devicemanagement.bootstrap;

import com.jt.devicemanagement.device.DeviceRepository;
import com.jt.devicemanagement.device.models.Device;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.deviceModel.models.OS;
import com.jt.devicemanagement.deviceModel.DeviceModelRepository;
import com.jt.devicemanagement.samples.GreetingService;
import com.jt.devicemanagement.user.UserRepository;
import com.jt.devicemanagement.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    GreetingService greetingService;

    private final DeviceModelRepository deviceModelRepository;
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;


    public Bootstrap(final DeviceModelRepository deviceModelRepository, final DeviceRepository deviceRepository, final UserRepository userRepository) {
        this.deviceModelRepository = deviceModelRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        loadDeviceModels();
        this.testSample();

    }

    private void loadDeviceModels() {
        DeviceModel deviceModel1 = new DeviceModel();
        deviceModel1.setId(1L);
        deviceModel1.setOs(OS.ANDROID);
        deviceModel1.setDescription("Samsung Galaxy 9");
        deviceModel1.setName("AND1");

        User user1 = new User();
        user1.setFirstName("Jon");
        user1.setLastName("Smith");

        Device device1 = new Device();
        device1.setAssetNumber("SAP123");
        device1.setName("DEV1");
        device1.setSerialNumber("afdsf-afdsf-123");
        device1.setDeviceModel(deviceModel1);
        device1.setUser(user1);

        deviceModelRepository.save(deviceModel1);
        userRepository.save(user1);
        deviceRepository.save(device1);

        DeviceModel deviceModel2 = new DeviceModel();
        deviceModel2.setId(2L);
        deviceModel2.setOs(OS.IOS);
        deviceModel2.setDescription("iPhone x");
        deviceModel2.setName("IPH1");

        User user2 = new User();
        user2.setFirstName("Kate");
        user2.setLastName("Hillmane");

        Device device2 = new Device();
        device2.setAssetNumber("SAP234");
        device2.setName("DEV2");
        device2.setSerialNumber("afdsf-afdsf-234");
        device2.setDeviceModel(deviceModel2);
        device2.setUser(user2);


        deviceModelRepository.save(deviceModel2);
        userRepository.save(user2);
        deviceRepository.save(device2);
    }

    private void testSample() {
        System.out.println("------------Sample testing---------------");
        System.out.println(greetingService.getGreeting());
        System.out.println("-----------------------------------------");
    }


}
