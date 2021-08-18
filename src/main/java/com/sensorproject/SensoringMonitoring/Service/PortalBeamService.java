package com.sensorproject.SensoringMonitoring.Service;

import com.sensorproject.SensoringMonitoring.Model.PortalBeamResponse.PortalBeamResponse;
import com.sensorproject.SensoringMonitoring.Model.Sensor;
import com.sensorproject.SensoringMonitoring.Model.Sensordata;
import com.sensorproject.SensoringMonitoring.Repository.SensorRepository;
import com.sensorproject.SensoringMonitoring.Repository.SensordataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
public class PortalBeamService {


    @Autowired
    SensordataRepository repository;
    @Autowired
    SensorRepository sensorRepository;

    public ResponseEntity<String> makePortalBeamApiCall(String startTime, String endTime, String trackingId, int length) {
        String url = "https://apps.cloud.us.kontakt.io/v3/telemetry?trackingId=" + trackingId + "&startTime=" + startTime + "&endTime=" + endTime + "&size=" + length;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("api-key", "WyQnRkGTRnLHfxkxsSzbjbmKEZtlWyrZ");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        return response;
    }

    public ResponseEntity<String> getLastPortalBeamData(String sensorId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        Date lastDate = new Date(System.currentTimeMillis() - 7300000);
        String dateSixMinBefor = dateFormat.format(lastDate);
        String dateNow = dateFormat.format(date);
        String url = "https://apps.cloud.us.kontakt.io/v3/telemetry?trackingId=" + sensorId + "&startTime=" + dateSixMinBefor + "&endTime=" + dateNow;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("api-key", "WyQnRkGTRnLHfxkxsSzbjbmKEZtlWyrZ");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        return response;
    }

    @Scheduled(fixedRate = 3600000L)
    void portalBeamDataScheduler() {
        List<Sensor> sensorList = sensorRepository.findAll();
        for (Sensor elem : sensorList) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date date = new Date();
            Date lastDate = new Date(System.currentTimeMillis() - 7300000);
            String dateSixMinBefor = dateFormat.format(lastDate);
            String dateNow = dateFormat.format(date);
            String url = "https://apps.cloud.us.kontakt.io/v3/telemetry?trackingId=" + elem.getSensorAddress() +
                    "&startTime=" + dateSixMinBefor + "&endTime=" + dateNow;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set("api-key", "WyQnRkGTRnLHfxkxsSzbjbmKEZtlWyrZ");
            HttpEntity request = new HttpEntity(headers);
            ResponseEntity<PortalBeamResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    request,
                    PortalBeamResponse.class,
                    1
            );
            Sensor sensor = sensorRepository.getSensorBySensorId(elem.getSensorId());
            Sensordata sensordata = new Sensordata();
            sensordata.setSensor(sensor);
            sensordata.setTrackingId(response.getBody().getContent()[0].getTrackingId());
            sensordata.setPeopleInRoom(response.getBody().getContent()[0].getNumberOfPeopleDetected());
            sensordata.setAirquality(response.getBody().getContent()[0].getAirQuality());
            sensordata.setTemperature((int) response.getBody().getContent()[0].getTemperature());
            sensordata.setLightIntensity(response.getBody().getContent()[0].getLightIntensity());
            sensordata.setHumidity(response.getBody().getContent()[0].getHumidity());
            sensordata.setBatteryLevel(response.getBody().getContent()[0].getBatteryLevel());
            sensordata.setCreationDate(response.getBody().getContent()[0].getTimestamp());
            repository.save(sensordata);
        }
    }
}
