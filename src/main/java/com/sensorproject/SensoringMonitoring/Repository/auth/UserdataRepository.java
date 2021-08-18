package com.sensorproject.SensoringMonitoring.Repository.auth;

import com.sensorproject.SensoringMonitoring.Model.auth.Userdata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserdataRepository extends JpaRepository<Userdata, Integer> {
    Userdata findUserdataByUsername(String username);
    List<Userdata> findAllByUsername(String username);


}
