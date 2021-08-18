package com.sensorproject.SensoringMonitoring.Repository;

import com.sensorproject.SensoringMonitoring.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Sensor getSensorBySensorId(int sensorId);
    List<Sensor> findAllByRoomId(int roomId);
}


