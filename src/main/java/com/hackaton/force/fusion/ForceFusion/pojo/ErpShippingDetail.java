package com.hackaton.force.fusion.ForceFusion.pojo;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
public class ErpShippingDetail {

    private String name;
    private String address;
    private String system;
    private String planet;


    public ErpShippingDetail () {

    }


    public ErpShippingDetail(final String name, final String address, final String system, final String planet) {
        this.name = name;
        this.address = address;
        this.system = system;
        this.planet = planet;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(final String system) {
        this.system = system;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(final String planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "ErpShippingDetail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", system='" + system + '\'' +
                ", planet='" + planet + '\'' +
                '}';
    }
}
