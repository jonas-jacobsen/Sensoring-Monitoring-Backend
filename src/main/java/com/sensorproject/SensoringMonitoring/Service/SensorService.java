package com.sensorproject.SensoringMonitoring.Service;

import com.sensorproject.SensoringMonitoring.Model.Sensor;
import com.sensorproject.SensoringMonitoring.Repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(int sensorId) {
        return sensorRepository.getSensorBySensorId(sensorId);
    }
    public List<Sensor> getSensorListByRoomId(int roomId){
        return sensorRepository.findAllByRoomId(roomId);
    }
}


