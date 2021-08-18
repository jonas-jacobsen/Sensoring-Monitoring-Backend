package com.sensorproject.SensoringMonitoring.Model;

public class PortalBeamData {
     private String trackingId;
     private String timestamp;
     private int batteryLevel;
     private int humidity;
     private int lightIntensity;
     private int rssi;
     private String sourceId;
     private double temperature;
     private int airQuality;
     private int numberOfPeopleDetected;
     private int secondsSincePeopleDetection;
     private String firmware;
     private int model;
     private int txPowerDbm;
     private String uniqueId;
     private int calibratedRssi1m;

     public PortalBeamData() {
     }

     public PortalBeamData(String trackingId, String timestamp, int batteryLevel, int humidity, int lightIntensity, int rssi, String sourceId, double temperature, int airQuality, int numberOfPeopleDetected, int secondsSincePeopleDetection, String firmware, int model, int txPowerDbm, String uniqueId, int calibratedRssi1m) {
          this.trackingId = trackingId;
          this.timestamp = timestamp;
          this.batteryLevel = batteryLevel;
          this.humidity = humidity;
          this.lightIntensity = lightIntensity;
          this.rssi = rssi;
          this.sourceId = sourceId;
          this.temperature = temperature;
          this.airQuality = airQuality;
          this.numberOfPeopleDetected = numberOfPeopleDetected;
          this.secondsSincePeopleDetection = secondsSincePeopleDetection;
          this.firmware = firmware;
          this.model = model;
          this.txPowerDbm = txPowerDbm;
          this.uniqueId = uniqueId;
          this.calibratedRssi1m = calibratedRssi1m;
     }

     public String getTrackingId() {
          return trackingId;
     }

     public void setTrackingId(String trackingId) {
          this.trackingId = trackingId;
     }

     public String getTimestamp() {
          return timestamp;
     }

     public void setTimestamp(String timestamp) {
          this.timestamp = timestamp;
     }

     public int getBatteryLevel() {
          return batteryLevel;
     }

     public void setBatteryLevel(int batteryLevel) {
          this.batteryLevel = batteryLevel;
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

     public int getRssi() {
          return rssi;
     }

     public void setRssi(int rssi) {
          this.rssi = rssi;
     }

     public String getSourceId() {
          return sourceId;
     }

     public void setSourceId(String sourceId) {
          this.sourceId = sourceId;
     }

     public double getTemperature() {
          return temperature;
     }

     public void setTemperature(double temperature) {
          this.temperature = temperature;
     }

     public int getAirQuality() {
          return airQuality;
     }

     public void setAirQuality(int airQuality) {
          this.airQuality = airQuality;
     }

     public int getNumberOfPeopleDetected() {
          return numberOfPeopleDetected;
     }

     public void setNumberOfPeopleDetected(int numberOfPeopleDetected) {
          this.numberOfPeopleDetected = numberOfPeopleDetected;
     }

     public int getSecondsSincePeopleDetection() {
          return secondsSincePeopleDetection;
     }

     public void setSecondsSincePeopleDetection(int secondsSincePeopleDetection) {
          this.secondsSincePeopleDetection = secondsSincePeopleDetection;
     }

     public String getFirmware() {
          return firmware;
     }

     public void setFirmware(String firmware) {
          this.firmware = firmware;
     }

     public int getModel() {
          return model;
     }

     public void setModel(int model) {
          this.model = model;
     }

     public int getTxPowerDbm() {
          return txPowerDbm;
     }

     public void setTxPowerDbm(int txPowerDbm) {
          this.txPowerDbm = txPowerDbm;
     }

     public String getUniqueId() {
          return uniqueId;
     }

     public void setUniqueId(String uniqueId) {
          this.uniqueId = uniqueId;
     }

     public int getCalibratedRssi1m() {
          return calibratedRssi1m;
     }

     public void setCalibratedRssi1m(int calibratedRssi1m) {
          this.calibratedRssi1m = calibratedRssi1m;
     }
}
