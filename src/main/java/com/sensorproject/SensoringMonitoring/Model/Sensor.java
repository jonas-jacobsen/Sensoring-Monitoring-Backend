package com.sensorproject.SensoringMonitoring.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;
    private int roomId;
    private String sensorAddress;
    private String sensorType;

    @OneToMany(mappedBy="sensor")
    private List<Sensordata> sensordataList;

    @ManyToOne
    @JoinColumn(name="room_roomId", nullable=false)
    private Room room;

    public Sensor() {
    }

    public Sensor(int sensorId, int roomId, String sensorAddress, String sensorType, List<Sensordata> sensordataList, Room room) {
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.sensorType = sensorType;
        this.sensordataList = sensordataList;
        this.room = room;
    }
    public int getSensorId() {
        return sensorId;
    }
    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getSensorAddress() {
        return sensorAddress;
    }
    public void setSensorAddress(String sensorAddress) {
        this.sensorAddress = sensorAddress;
    }
    public String getSensorType() {
        return sensorType;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    @JsonManagedReference
    public List<Sensordata> getSensordataList() {
        return sensordataList;
    }
    public void setSensordataList(List<Sensordata> sensordataList) {
        this.sensordataList = sensordataList;
    }
    @JsonBackReference
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}




