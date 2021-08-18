package com.sensorproject.SensoringMonitoring.Service;

import com.sensorproject.SensoringMonitoring.Model.Sensor;
import com.sensorproject.SensoringMonitoring.Model.Sensordata;
import com.sensorproject.SensoringMonitoring.Repository.SensorRepository;
import com.sensorproject.SensoringMonitoring.Repository.SensordataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SensordataService {

    @Autowired
    SensordataRepository sensordataRepository;
    @Autowired
    SensorRepository sensorRepository;

    public List<Sensordata> getSensordataBetweenDate(String a, String b, int sensorId){
        Sensor sensor = sensorRepository.getSensorBySensorId(sensorId);
        return sensordataRepository.findAllByCreationDateLessThanEqualAndCreationDateGreaterThanEqualAndSensor(a, b, sensor);
    }

    public List<Sensordata> getSensordataBySensorId(int sensorId){
        Sensor sensor = sensorRepository.getSensorBySensorId(sensorId);
        return sensordataRepository.findAllBySensor(sensor);
    }
    public Sensordata getLastSensorData(int sensorId){
        Sensor sensor = sensorRepository.getSensorBySensorId(sensorId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        Date lastDate = new Date(System.currentTimeMillis() - 3600 * 4000);
        String dateSixMinBefor = dateFormat.format(lastDate);
        String dateNow = dateFormat.format(date);
        List<Sensordata> sensordataList = sensordataRepository.findAllByCreationDateLessThanEqualAndCreationDateGreaterThanEqualAndSensor(dateNow, dateSixMinBefor, sensor);
        if(sensordataList.isEmpty()){
            return null;
        }else {
            Sensordata sensordata = sensordataList.get(sensordataList.size()-1);
            return sensordata;
        }
    }
}
