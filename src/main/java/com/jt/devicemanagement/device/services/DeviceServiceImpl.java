package com.jt.devicemanagement.device.services;

import com.jt.devicemanagement.device.DeviceRepository;
import com.jt.devicemanagement.device.api.DeviceDTO;
import com.jt.devicemanagement.device.api.DeviceMapper;
import com.jt.devicemanagement.device.models.Device;
import com.jt.devicemanagement.device.util.SerialNumberPrefix;
import com.jt.devicemanagement.deviceModel.api.DeviceModelDTO;
import com.jt.devicemanagement.deviceModel.models.DeviceModel;
import com.jt.devicemanagement.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    SerialNumberPrefix serialNumberPrefix;

    private DeviceRepository deviceRepository;
    private DeviceMapper deviceMapper;


    public DeviceServiceImpl(final DeviceRepository deviceRepository, final DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<DeviceDTO> getAllDevices() {
        return deviceRepository.findAll().stream().map(deviceMapper::DeviceToDeviceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeviceDTO getDeviceBySerialNumber(final String serialNumber) {
        Optional<Device> device = deviceRepository.findById(serialNumber);
        if (device.isPresent()) {
            return deviceMapper.DeviceToDeviceDTO(device.get());
        } else {
            throw new EntityNotFoundException();
        }

    }

    @Override
    public List<DeviceDTO> getDevicesByModelId(final Long id) {
        return deviceRepository.getDevicesByModelId(id).stream()
                .map(deviceMapper::DeviceToDeviceDTO).collect(Collectors.toList());
    }

    @Override
    public DeviceDTO createDevice(final DeviceDTO deviceDTO) {
        String serialNumber = deviceDTO.getSerialNumber();
        deviceDTO.setSerialNumber(serialNumberPrefix.getPrefix() + serialNumber);
        return saveAndReturnDeviceDTO(deviceMapper.DeviceDTOToDevice(deviceDTO));
    }

    private DeviceDTO saveAndReturnDeviceDTO(Device device) {
        Device saved= deviceRepository.save(device);
        return deviceMapper.DeviceToDeviceDTO(saved);
    }

    @Override
    public DeviceDTO updateDevice(final String serialNumber, final DeviceDTO deviceDTO) {
        Device device = deviceMapper.DeviceDTOToDevice(deviceDTO);
        device.setSerialNumber(serialNumber);
        return saveAndReturnDeviceDTO(device);

    }

    @Override
    public void deleteDevice(final String serialNumber) {
        deviceRepository.deleteById(serialNumber);

    }
}
