package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Model.DateBetween;
import com.sensorproject.SensoringMonitoring.Model.Sensordata;
import com.sensorproject.SensoringMonitoring.Service.SensordataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/sensordata")
public class SensordataController {


    @Autowired
    private SensordataService sensordataService;


    @PostMapping(value = "/getbetweendates/{sensorId}")
    public List<Sensordata> getSensordataBetweenDates(@PathVariable int sensorId, @RequestBody DateBetween dateBetween) {
        String a = dateBetween.getFrom();
        String b = dateBetween.getTo();
        return sensordataService.getSensordataBetweenDate(b, a, sensorId);
    }

    @GetMapping("/getlastfromsensor/{sensorId}")
    public Sensordata getLastBySensorId(@PathVariable int sensorId) {
        Sensordata sensordata = sensordataService.getLastSensorData(sensorId);
        return sensordata;
    }

    @GetMapping("/getbysensorid/{sensorId}")
    public List<Sensordata> getListBySensorId(@PathVariable int sensorId) {
        List<Sensordata> sensorsdata = sensordataService.getSensordataBySensorId(sensorId);
        return sensorsdata;
    }
}
