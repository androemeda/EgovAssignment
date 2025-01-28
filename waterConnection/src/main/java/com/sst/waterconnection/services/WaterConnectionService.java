package com.sst.water_connection.services;

import com.sst.water_connection.dtos.WaterConnectionDto;
import com.sst.water_connection.models.WaterConnection;

public interface WaterConnectionService {
    WaterConnection getWaterConnectionById(Long id);
    WaterConnection createWaterConnection(WaterConnectionDto waterConnectionDto);
    WaterConnection updateWaterConnection(Long id,WaterConnection waterConnection);
}