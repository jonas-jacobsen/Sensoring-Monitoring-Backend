package com.sensorproject.SensoringMonitoring.Repository;

import com.sensorproject.SensoringMonitoring.Model.Sensor;
import com.sensorproject.SensoringMonitoring.Model.Sensordata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensordataRepository extends JpaRepository<Sensordata, Integer> {
    List<Sensordata> findAllByCreationDateLessThanEqualAndCreationDateGreaterThanEqualAndSensor(String endDate, String startDate, Sensor sensor);
    List<Sensordata> findAllBySensor(Sensor sensor);
}
