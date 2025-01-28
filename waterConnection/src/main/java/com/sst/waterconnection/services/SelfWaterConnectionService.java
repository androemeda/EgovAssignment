package com.sst.water_connection.services;

import com.sst.water_connection.dtos.WaterConnectionDto;
import com.sst.water_connection.models.WaterConnection;
import org.springframework.stereotype.Service;
import com.sst.water_connection.repositories.WaterConnectionRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SelfWaterConnectionService implements WaterConnectionService {
    private final WaterConnectionRepository waterConnectionRepository;
    private WaterConnectionRepository connectionRepository;
    public SelfWaterConnectionService(WaterConnectionRepository connectionRepository, WaterConnectionRepository waterConnectionRepository) {
        this.connectionRepository = connectionRepository;
        this.waterConnectionRepository = waterConnectionRepository;
    }
    @Override
    public WaterConnection getWaterConnectionById(Long id) {
        Optional<WaterConnection> waterConnectionOptional = connectionRepository.findById(id);
        if (waterConnectionOptional.isEmpty()) {
            throw new Error("There is no water connection with id " + id);
        }

        return waterConnectionOptional.get();
    }

    @Override
    public WaterConnection createWaterConnection(WaterConnectionDto waterConnectionDto) {
        WaterConnection waterConnection = new WaterConnection();
        waterConnection.setWaterconnection_id(waterConnectionDto.getWaterconnection_id());
        waterConnection.setProperty_id(waterConnectionDto.getProperty_id());
        waterConnection.setDescription(waterConnectionDto.getDescription());

        waterConnectionRepository.save(waterConnection);
        return waterConnection;
    }

    @Override
    public WaterConnection updateWaterConnection(Long id, WaterConnection updatedWaterConnection) {
        Optional<WaterConnection> optionalConnection = waterConnectionRepository.findById(id);


        WaterConnection waterConnection = optionalConnection.get();
        if(updatedWaterConnection.getDescription() != null){
            waterConnection.setDescription(updatedWaterConnection.getDescription());
        }

        return waterConnectionRepository.save(waterConnection);
    }

}