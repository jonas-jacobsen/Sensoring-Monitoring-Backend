package com.sensorproject.SensoringMonitoring.Model.PortalBeamResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sensorproject.SensoringMonitoring.Model.PortalBeamData;

import java.util.List;

public class PortalBeamResponse {


    private Links[] links;

    private Page page;

    private PortalBeamData[] content;

    @JsonCreator
    public PortalBeamResponse(@JsonProperty("links") Links[] links, @JsonProperty("page")Page page, @JsonProperty("content")PortalBeamData[] content) {
        this.links = links;
        this.page = page;
        this.content = content;
    }




    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public PortalBeamData[] getContent() {
        return content;
    }

    public void setContent(PortalBeamData[] content) {
        this.content = content;
    }
}
