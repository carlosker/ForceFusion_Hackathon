package com.hackaton.force.fusion.ForceFusion.pojo;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
public class ErpOrderItem {

    private String product_id;
    private int quantity;

    public ErpOrderItem() {

    }

    public ErpOrderItem(final String product_id, final int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(final String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ErpOrderItem{" +
                "product_id='" + product_id + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
