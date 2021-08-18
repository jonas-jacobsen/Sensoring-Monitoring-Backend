package com.sensorproject.SensoringMonitoring.Repository.auth;

import com.sensorproject.SensoringMonitoring.Model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
