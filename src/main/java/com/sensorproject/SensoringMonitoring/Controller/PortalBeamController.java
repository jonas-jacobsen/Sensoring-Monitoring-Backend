package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Model.DateBetween;
import com.sensorproject.SensoringMonitoring.Service.PortalBeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(value = "/sensor/portalbeam")
public class PortalBeamController {

    @Autowired
    private PortalBeamService portalBeamService;

    //portal Beam Rest Call
    @PostMapping("/getdatesbetween/{length}")
    public ResponseEntity<String> getPortalBeamData(@RequestBody DateBetween dateBetween, @PathVariable int length) {
        return portalBeamService.makePortalBeamApiCall(dateBetween.getFrom(),dateBetween.getTo(),"c6:6d:4a:b8:f7:05", length);
    }
    @GetMapping("/getlastdates/{sensorId}")
    public ResponseEntity<String> getLastPortalBeamData(@PathVariable String sensorId) {
        return portalBeamService.getLastPortalBeamData(sensorId);
    }



}
