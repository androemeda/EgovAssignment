package com.sst.water_connection.controllers;

import com.sst.water_connection.dtos.WaterConnectionDto;
import com.sst.water_connection.models.WaterConnection;
import com.sst.water_connection.services.WaterConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/waterconnections")
public class WaterConnecterController {
    private WaterConnectionService waterConnectionService;
    public WaterConnecterController(WaterConnectionService waterConnectionService) {
        this.waterConnectionService = waterConnectionService;
    }

    @GetMapping("/{id}")
    public WaterConnection getWaterConnectionById(@PathVariable("id") Long id) {
        return waterConnectionService.getWaterConnectionById(id);
    }
    @PostMapping
    public ResponseEntity<String> createWaterConnection(@RequestBody WaterConnectionDto waterConnectionDto) {
         waterConnectionService.createWaterConnection(waterConnectionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created a new WaterConnection");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateWaterConnection(@PathVariable("id")Long id,@RequestBody WaterConnection waterConnection) {
        waterConnectionService.updateWaterConnection(id,waterConnection);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated a WaterConnection");
    }
}