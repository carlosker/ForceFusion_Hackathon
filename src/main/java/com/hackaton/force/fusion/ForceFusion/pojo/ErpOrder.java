package com.hackaton.force.fusion.ForceFusion.pojo;

import java.util.List;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
public class ErpOrder {

    private String orderId;
    private String username;
    private String total_amount;
    private String order_date;
    private String shipping_date;
    private List<ErpOrderItem> order_items;
    private ErpShippingDetail shipping_details;

    public ErpOrder() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(final String total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(final String order_date) {
        this.order_date = order_date;
    }

    public String getShipping_date() {
        return shipping_date;
    }

    public void setShipping_date(final String shipping_date) {
        this.shipping_date = shipping_date;
    }

    public List<ErpOrderItem> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(final List<ErpOrderItem> order_items) {
        this.order_items = order_items;
    }

    public ErpShippingDetail getShipping_details() {
        return shipping_details;
    }

    public void setShipping_details(final ErpShippingDetail shipping_details) {
        this.shipping_details = shipping_details;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ErpOrder{" +
                "orderId='" + orderId + '\'' +
                ", username='" + username + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", order_date='" + order_date + '\'' +
                ", shipping_date='" + shipping_date + '\'' +
                ", order_items=" + order_items.toString() +
                ", shipping_details=" + shipping_details.toString() +
                '}';
    }
}
