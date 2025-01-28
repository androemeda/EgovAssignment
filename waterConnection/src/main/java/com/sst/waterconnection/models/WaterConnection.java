package com.sst.water_connection.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="waterconnection")
public class WaterConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "waterconnection_id")
    private Long waterconnection_id;
    @Column(name = "property_id")
    private Long property_id;
    @Column(name = "description")
    private String description;

    public WaterConnection() {}

    public WaterConnection(Long id, Long waterconnection_id, Long property_id, String description) {
        this.id = id;
        this.waterconnection_id = waterconnection_id;
        this.property_id = property_id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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