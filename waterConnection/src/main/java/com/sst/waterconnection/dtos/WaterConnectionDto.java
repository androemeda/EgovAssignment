package com.sst.water_connection.dtos;

public class WaterConnectionDto
{
    private Long waterconnection_id;
    private Long property_id;
    private String description;

    public Long getWaterconnection_id() {
        return waterconnection_id;
    }

    public void setWaterconnection_id(Long waterconnection_id) {
        this.waterconnection_id = waterconnection_id;
    }

    public Long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Long property_id) {
        this.property_id = property_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}