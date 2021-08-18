package com.sensorproject.SensoringMonitoring.Repository;

import com.sensorproject.SensoringMonitoring.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomByRoomId(int roomId);
    Room findByRoomName(String roomName);
    List<Room> findAllByFloor(String floor);
}
