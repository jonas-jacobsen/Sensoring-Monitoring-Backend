package com.sensorproject.SensoringMonitoring.Model.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userdata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String testdata;

    public Userdata() {
    }

    public Userdata(int id, String username, String testdata) {
        this.id = id;
        this.username = username;
        this.testdata = testdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTestdata() {
        return testdata;
    }

    public void setTestdata(String userdata) {
        this.testdata = userdata;
    }
}
