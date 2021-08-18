package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Model.Data.OverviewData;
import com.sensorproject.SensoringMonitoring.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/current")
    public OverviewData getCurrentOverviewData(){
        return dataService.getCurrentOverviewData();
    }


    @GetMapping("/mostpeople")
    public int getOMostPeople(){
        return dataService.getAverageTemp();
    }
}
