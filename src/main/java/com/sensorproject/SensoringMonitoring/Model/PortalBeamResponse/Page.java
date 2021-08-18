package com.sensorproject.SensoringMonitoring.Model.PortalBeamResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page {

    @JsonProperty(value = "startTime", required = true)
    private String startTime;
    @JsonProperty(value = "endTime", required = true)
    private String endTime;
    @JsonProperty(value = "hasNext", required = true)
    private boolean hasNext;
    @JsonProperty(value = "size", required = true)
    private int size;

    public Page() {
    }

    public Page(String startTime, String endTime, boolean hasNext, int size) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.hasNext = hasNext;
        this.size = size;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
