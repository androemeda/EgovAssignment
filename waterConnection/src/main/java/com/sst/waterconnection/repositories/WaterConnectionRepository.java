package com.sst.water_connection.repositories;

import com.sst.water_connection.models.WaterConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WaterConnectionRepository extends JpaRepository<WaterConnection,Long> {
    @Override
    Optional<WaterConnection> findById(Long id);

    @Override
    WaterConnection save(WaterConnection waterConnection);
}