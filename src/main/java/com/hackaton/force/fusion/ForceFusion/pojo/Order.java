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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "order_id",
        "username",
        "email",
        "cypher",
        "total_amount",
        "currency",
        "date",
        "shipping_details",
        "payment_details",
        "order_items",
        "client_headers"
})
public class Order {
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("cypher")
    private String cypher;
    @JsonProperty("total_amount")
    private String totalAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("date")
    private String date;
    @JsonProperty("shipping_details")
    private ShippingDetails shippingDetails;
    @JsonProperty("payment_details")
    private PaymentDetails paymentDetails;
    @JsonProperty("order_items")
    private List<OrderItem> orderItems;
    @JsonProperty("client_headers")
    private ClientHeaders clientHeaders;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("cypher")
    public String getCypher() {
        return cypher;
    }

    @JsonProperty("cypher")
    public void setCypher(String cypher) {
        this.cypher = cypher;
    }

    @JsonProperty("total_amount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("total_amount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("shipping_details")
    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    @JsonProperty("shipping_details")
    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @JsonProperty("payment_details")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("payment_details")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("order_items")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @JsonProperty("order_items")
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @JsonProperty("client_headers")
    public ClientHeaders getClientHeaders() {
        return clientHeaders;
    }

    @JsonProperty("client_headers")
    public void setClientHeaders(ClientHeaders clientHeaders) {
        this.clientHeaders = clientHeaders;
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