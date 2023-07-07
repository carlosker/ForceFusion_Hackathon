package com.hackaton.force.fusion.ForceFusion.pojo;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Order {

    private String orderId;

    private String username;

    private String email;

    private String cypher;

    private String totalAmount;

    private String currency;

    private String date;

    private ShippingDetails shippingDetails;

    private PaymentDetails paymentDetails;

    private List<OrderItem> orderItems;

    private ClientHeaders clientHeaders;

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getCypher() {
        return cypher;
    }


    public void setCypher(String cypher) {
        this.cypher = cypher;
    }


    public String getTotalAmount() {
        return totalAmount;
    }


    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }


    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }


    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }


    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public ClientHeaders getClientHeaders() {
        return clientHeaders;
    }


    public void setClientHeaders(ClientHeaders clientHeaders) {
        this.clientHeaders = clientHeaders;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}