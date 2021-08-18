package com.sensorproject.SensoringMonitoring.Service;

import com.sensorproject.SensoringMonitoring.Model.Room;
import com.sensorproject.SensoringMonitoring.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Room getRoomByRoomId(int roomId){
        return roomRepository.findRoomByRoomId(roomId);
    }
    public List<Room> getRoomList(){return roomRepository.findAll();}
    public Room getRoomByName(String roomName){
        return roomRepository.findByRoomName(roomName);
    }
}
