package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Service.SensorService;
import com.sensorproject.SensoringMonitoring.Model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/getbyid/{sensorId}")
    public Sensor getSensorById(@PathVariable int sensorId) {
        Sensor sensor = sensorService.getSensorById(sensorId);
        return sensor;
    }
    @GetMapping("/getall")
    public List<Sensor> getSensors() {
        List<Sensor> sensors = sensorService.getSensors();
        return sensors;
    }
    @GetMapping("/getallofroom/{roomId}")
    public List<Sensor> getSensorListOfRoom(@PathVariable int roomId){
        List<Sensor> sensors = sensorService.getSensorListByRoomId(roomId);
        return sensors;
    }
}




