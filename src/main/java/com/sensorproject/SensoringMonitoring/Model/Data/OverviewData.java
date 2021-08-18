package com.sensorproject.SensoringMonitoring.Model.Data;

public class OverviewData {

    //model for current data of all Rooms
    int numberOfMeetingRooms;
    int numberOfConferenceRooms;
    String roomWithMostPeople;
    String roomWithColdestTemperature;
    int numberOfFreeRooms;
    int numberOfOccupiedRooms;
    int averageTemperature;
    int averageHumidity;
    int averageLightintensity;

    public OverviewData() {
    }

    public OverviewData(int numberOfMeetingRooms, int numberOfConferenceRooms, String roomWithMostPeople, String roomWithColdestTemperature, int numberOfFreeRooms, int numberOfOccupiedRooms, int averageTemperature, int averageHumidity, int averageLightintensity) {
        this.numberOfMeetingRooms = numberOfMeetingRooms;
        this.numberOfConferenceRooms = numberOfConferenceRooms;
        this.roomWithMostPeople = roomWithMostPeople;
        this.roomWithColdestTemperature = roomWithColdestTemperature;
        this.numberOfFreeRooms = numberOfFreeRooms;
        this.numberOfOccupiedRooms = numberOfOccupiedRooms;
        this.averageTemperature = averageTemperature;
        this.averageHumidity = averageHumidity;
        this.averageLightintensity = averageLightintensity;
    }

    public int getNumberOfMeetingRooms() {
        return numberOfMeetingRooms;
    }

    public void setNumberOfMeetingRooms(int numberOfMeetingRooms) {
        this.numberOfMeetingRooms = numberOfMeetingRooms;
    }

    public int getNumberOfConferenceRooms() {
        return numberOfConferenceRooms;
    }

    public void setNumberOfConferenceRooms(int numberOfConferenceRooms) {
        this.numberOfConferenceRooms = numberOfConferenceRooms;
    }

    public String getRoomWithMostPeople() {
        return roomWithMostPeople;
    }

    public void setRoomWithMostPeople(String roomWithMostPeople) {
        this.roomWithMostPeople = roomWithMostPeople;
    }

    public String getRoomWithColdestTemperature() {
        return roomWithColdestTemperature;
    }

    public void setRoomWithColdestTemperature(String roomWithColdestTemperature) {
        this.roomWithColdestTemperature = roomWithColdestTemperature;
    }

    public int getNumberOfFreeRooms() {
        return numberOfFreeRooms;
    }

    public void setNumberOfFreeRooms(int numberOfFreeRooms) {
        this.numberOfFreeRooms = numberOfFreeRooms;
    }

    public int getNumberOfOccupiedRooms() {
        return numberOfOccupiedRooms;
    }

    public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
        this.numberOfOccupiedRooms = numberOfOccupiedRooms;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public int getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(int averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public int getAverageLightintensity() {
        return averageLightintensity;
    }

    public void setAverageLightintensity(int averageLightintensity) {
        this.averageLightintensity = averageLightintensity;
    }
}
