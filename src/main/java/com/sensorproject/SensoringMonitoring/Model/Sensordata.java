package com.sensorproject.SensoringMonitoring.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class Sensordata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensordataId;
    private String trackingId;
    private int peopleInRoom;
    private int airquality;
    private int temperature;
    private int humidity;
    private int lightIntensity;
    private int batteryLevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private String creationDate;

    @ManyToOne
    @JoinColumn(name="sensor_sensorId", nullable=false)
    private Sensor sensor;

    public Sensordata() {
    }

    public Sensordata(int sensordataId, String trackingId, int peopleInRoom, int airquality, int temperature, int humidity, int lightIntensity, int batteryLevel, String creationDate, Sensor sensor) {
        this.sensordataId = sensordataId;
        this.trackingId = trackingId;
        this.peopleInRoom = peopleInRoom;
        this.airquality = airquality;
        this.temperature = temperature;
        this.humidity = humidity;
        this.lightIntensity = lightIntensity;
        this.batteryLevel = batteryLevel;
        this.creationDate = creationDate;
        this.sensor = sensor;
    }

    public int getSensordataId() {
        return sensordataId;
    }

    public void setSensordataId(int sensordataId) {
        this.sensordataId = sensordataId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public int getPeopleInRoom() {
        return peopleInRoom;
    }

    public void setPeopleInRoom(int peopleInRoom) {
        this.peopleInRoom = peopleInRoom;
    }

    public int getAirquality() {
        return airquality;
    }

    public void setAirquality(int airquality) {
        this.airquality = airquality;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(int lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @JsonBackReference
    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}

