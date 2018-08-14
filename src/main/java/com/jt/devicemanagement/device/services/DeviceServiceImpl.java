package com.jt.devicemanagement.device.services;

import com.jt.devicemanagement.device.DeviceRepository;
import com.jt.devicemanagement.device.api.DeviceDTO;
import com.jt.devicemanagement.device.api.DeviceMapper;
import com.jt.devicemanagement.device.models.Device;
import com.jt.devicemanagement.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

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
    public DeviceDTO getDeviceByModelId(final Long id) {
        return null;
    }

    @Override
    public DeviceDTO createDevice(final DeviceDTO deviceDTO) {
        return null;
    }

    @Override
    public DeviceDTO updateDevice(final String serialNumber, final DeviceDTO deviceDTO) {
        return null;
    }

    @Override
    public void deleteDevice(final String serialNumber) {

    }
}
