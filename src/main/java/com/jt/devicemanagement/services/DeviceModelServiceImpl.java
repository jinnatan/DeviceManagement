package com.jt.devicemanagement.services;

import com.jt.devicemanagement.api.DTOs.DeviceModelDTO;
import com.jt.devicemanagement.api.mappers.DeviceModelMapper;
import com.jt.devicemanagement.models.DeviceModel;
import com.jt.devicemanagement.repositories.DeviceModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceModelServiceImpl implements DeviceModelService {

    private DeviceModelRepository deviceModelRepository;
    private DeviceModelMapper deviceModelMapper;

    public DeviceModelServiceImpl(final DeviceModelRepository deviceModelRepository, final DeviceModelMapper deviceModelMapper) {
        this.deviceModelRepository = deviceModelRepository;
        this.deviceModelMapper = deviceModelMapper;
    }

    @Override
    public List<DeviceModelDTO> getAllDeviceModels() {
        return this.deviceModelRepository.findAll().stream()
                .map(deviceModelMapper::DeviceModelToDeviceModelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeviceModelDTO getDeviceModelById(Long id) {
        Optional<DeviceModel> deviceModel = this.deviceModelRepository.findById(id);
        if (deviceModel.isPresent()) {
            return deviceModelMapper.DeviceModelToDeviceModelDTO(deviceModel.get());
        }
        else {
            throw new RuntimeException(); // TODO. Fix this
        }

    }

    @Override
    public DeviceModelDTO createDeviceModel(final DeviceModelDTO deviceModelDTO) {
        return saveAndReturnDeviceModelDTO(deviceModelMapper.DeviceModelDTOToDeviceModel(deviceModelDTO));
    }

    private DeviceModelDTO saveAndReturnDeviceModelDTO(DeviceModel deviceModel) {
        DeviceModel saved= deviceModelRepository.save(deviceModel);
        return deviceModelMapper.DeviceModelToDeviceModelDTO(saved);
    }


    @Override
    public DeviceModelDTO updateDeviceModel(final Long id, final DeviceModelDTO deviceModelDTO) {
        DeviceModel deviceModel = deviceModelMapper.DeviceModelDTOToDeviceModel(deviceModelDTO);
        deviceModel.setId(id);
        return saveAndReturnDeviceModelDTO(deviceModel);
    }

    @Override
    public void deleteDeviceModel(final Long id) {
        deviceModelRepository.deleteById(id);
    }
}
