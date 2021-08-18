package com.sensorproject.SensoringMonitoring.Service;

import com.sensorproject.SensoringMonitoring.Model.Data.OverviewData;
import com.sensorproject.SensoringMonitoring.Model.Room;
import com.sensorproject.SensoringMonitoring.Model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensordataService sensordataService;

    @Autowired
    private RoomService roomService;

    public OverviewData getCurrentOverviewData() {
        OverviewData overviewData = new OverviewData();
        overviewData.setNumberOfOccupiedRooms(getOccupiedRooms());
        overviewData.setNumberOfFreeRooms(getFreeRooms());
        overviewData.setNumberOfMeetingRooms(getNumberOfMeetingrooms());
        overviewData.setNumberOfConferenceRooms(getNumberOfConferenceRooms());
        overviewData.setRoomWithMostPeople(getRoomWithMostPeople());
        overviewData.setRoomWithColdestTemperature(getRoomWithMostColdestTemperature());
        overviewData.setAverageTemperature(getAverageTemp());
        overviewData.setAverageHumidity(getAverageHumitity());
        overviewData.setAverageLightintensity(getAverageLightIntensity());
        return overviewData;
    }

    public int getOccupiedRooms() {
        int occupiedRooms = 0;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                if (sensordataService.getLastSensorData(sensorId).getPeopleInRoom() > 0) {
                    occupiedRooms++;
                }
            }
        }
        return occupiedRooms;
    }

    public int getFreeRooms() {
        int freeRooms = 0;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                if (sensordataService.getLastSensorData(sensorId).getPeopleInRoom() == 0) {
                    freeRooms++;
                }
            }
        }
        return freeRooms;
    }

    public int getNumberOfMeetingrooms() {
        int numberOfMeetingrooms = 0;
        List<Room> roomList = roomService.getRoomList();
        for (Room elem : roomList) {
            if (elem.getRoomType().equals("Meetingroom")) {
                numberOfMeetingrooms++;
            }
        }
        return numberOfMeetingrooms;
    }

    public int getNumberOfConferenceRooms() {
        int number = 0;
        List<Room> roomList = roomService.getRoomList();
        for (Room elem : roomList) {
            if (elem.getRoomType().equals("Conferenceroom")) {
                number++;
            }
        }
        return number;
    }

    public String getRoomWithMostPeople() {
        String roomWithMostPeople = "";
        int peopleInRoom = 0;
        Room room;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                if (sensordataService.getLastSensorData(sensorId).getPeopleInRoom() > peopleInRoom) {
                    peopleInRoom = sensordataService.getLastSensorData(sensorId).getPeopleInRoom();
                    room = roomService.getRoomByRoomId(elem.getRoomId());
                    roomWithMostPeople = room.getRoomName();
                }
            }
        }
        return roomWithMostPeople;
    }

    public String getRoomWithMostColdestTemperature() {
        String roomWithColdestTemp = "";
        int coldestTemp = 0;
        Room room;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                if (sensordataService.getLastSensorData(sensorId).getTemperature() > coldestTemp) {
                    coldestTemp = sensordataService.getLastSensorData(sensorId).getTemperature();
                    room = roomService.getRoomByRoomId(elem.getRoomId());
                    roomWithColdestTemp = room.getRoomName();
                }
            }
        }
        return roomWithColdestTemp;
    }

    public int getAverageTemp() {
        ArrayList<Integer> averageTempList = new ArrayList<Integer>();
        Room room;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                averageTempList.add(sensordataService.getLastSensorData(sensorId).getTemperature());
            }
        }
        return getAverage(averageTempList);
    }

    public int getAverageHumitity() {
        ArrayList<Integer> averageList = new ArrayList<Integer>();
        Room room;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                averageList.add(sensordataService.getLastSensorData(sensorId).getHumidity());
            }
        }
        return getAverage(averageList);
    }

    public int getAverageLightIntensity() {
        ArrayList<Integer> averageLightList = new ArrayList<Integer>();
        Room room;
        List<Sensor> sensorList = sensorService.getSensors();
        for (Sensor elem : sensorList) {
            int sensorId = elem.getSensorId();
            if (sensordataService.getLastSensorData(sensorId) != null) {
                averageLightList.add(sensordataService.getLastSensorData(sensorId).getLightIntensity());
            }
        }
        return getAverage(averageLightList);
    }

    public int getAverage(List<Integer> average){
        int total = 0;
        int averageTemp = 0;
        for (int i = 0; i < average.size(); i++) {
            total += average.get(i);
            averageTemp = total / average.size(); // finding ther average value
        }
        return averageTemp;
    }

}
