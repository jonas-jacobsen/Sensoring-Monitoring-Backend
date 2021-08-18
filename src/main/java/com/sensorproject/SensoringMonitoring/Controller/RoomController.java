package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Model.Room;
import com.sensorproject.SensoringMonitoring.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getbyId/{roomId}")
    public Room getById(@PathVariable int roomId) {
        Room room = roomService.getRoomByRoomId(roomId);
        return room;
    }
    @GetMapping("/getall")
    public List<Room> getAll() {
        List<Room> roomList = roomService.getRoomList();
        return roomList;
    }

    @GetMapping("/getbyname/{roomName}")
    public Room getByRoomName(@PathVariable String roomName) {
        Room room = roomService.getRoomByName(roomName);
        return room;
    }

}
