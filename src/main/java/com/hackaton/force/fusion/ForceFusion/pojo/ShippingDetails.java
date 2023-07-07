package com.hackaton.force.fusion.ForceFusion.pojo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "address",
        "system",
        "planet"
})

public class ShippingDetails {

    @JsonProperty("name")

    private String name;
    @JsonProperty("address")

    private String address;
    @JsonProperty("system")

    private String system;
    @JsonProperty("planet")

    private String planet;
    @JsonIgnore

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("system")

    public String getSystem() {
        return system;
    }

    @JsonProperty("system")

    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("planet")

    public String getPlanet() {
        return planet;
    }

    @JsonProperty("planet")

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    @JsonAnyGetter

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
