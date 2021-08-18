package com.sensorproject.SensoringMonitoring.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room {
    @Id
    private int roomId;
    private String roomName;
    private String roomType;
    private String floor;
    private String building;
    private String imageUrl;

    @OneToMany(mappedBy="room")
    private List<Sensor>sensorList;

    public Room() {
    }

    public Room(int roomId, String roomName, String roomType, String floor, String building, String imageUrl, List<Sensor> sensorList) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.floor = floor;
        this.building = building;
        this.imageUrl = imageUrl;
        this.sensorList = sensorList;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonManagedReference
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
