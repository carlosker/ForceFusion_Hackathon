package com.hackaton.force.fusion.ForceFusion.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "user_agent",
        "x_planet"
})

public class ClientHeaders {

    @JsonProperty("user_agent")
    private String userAgent;
    @JsonProperty("x_planet")
    private String xPlanet;

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("user_agent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("user_agent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @JsonProperty("x_planet")
    public String getxPlanet() {
        return xPlanet;
    }

    @JsonProperty("x_planet")
    public void setxPlanet(String xPlanet) {
        this.xPlanet = xPlanet;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}