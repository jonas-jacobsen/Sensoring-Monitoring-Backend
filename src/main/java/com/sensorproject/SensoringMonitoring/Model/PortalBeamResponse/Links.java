package com.sensorproject.SensoringMonitoring.Model.PortalBeamResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

    @JsonProperty(value = "rel", required = true)
    private String rel;
    @JsonProperty(value = "href", required = true)
    private String href;

    @JsonCreator
    public Links(@JsonProperty("rel") String rel, @JsonProperty("href") String href) {
        this.rel = rel;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
