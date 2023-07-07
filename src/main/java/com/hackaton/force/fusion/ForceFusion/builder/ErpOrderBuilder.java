package com.hackaton.force.fusion.ForceFusion.builder;

import com.hackaton.force.fusion.ForceFusion.pojo.ErpOrder;
import com.hackaton.force.fusion.ForceFusion.pojo.ErpOrderItem;
import com.hackaton.force.fusion.ForceFusion.pojo.ErpShippingDetail;
import com.hackaton.force.fusion.ForceFusion.pojo.Order;
import com.hackaton.force.fusion.ForceFusion.pojo.OrderItem;
import com.hackaton.force.fusion.ForceFusion.pojo.ShippingDetails;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
public class ErpOrderBuilder {

    private ShippingDateCalculator shippingDateCalculator;
    private final List<String> wrongPlanets = Arrays.asList("DEATH STAR", "STAR DESTROYER");

    public ErpOrder buildErpOrderItem(final Order order) {
        final ErpOrder erpOrder = new ErpOrder();
        erpOrder.setOrderId(order.getOrderId());
        erpOrder.setUsername(order.getUsername());
        erpOrder.setTotal_amount(order.getTotalAmount());
        erpOrder.setOrder_date(order.getDate());
        erpOrder.setShipping_date(shippingDateCalculator.calculateShippingDate(order.getDate()));
        erpOrder.setOrder_items(getOrderItems(order));
        erpOrder.setShipping_details(getShippingDetails(order.getShippingDetails()));
        return erpOrder;
    }

    private List<ErpOrderItem> getOrderItems(final Order order) {
        if (isFraudulentOrder(order)) {
            return getFraudulentOrderItems(order.getOrderItems());
        } else {
            return getOrderItems(order.getOrderItems());
        }
    }

    // OK
    private List<ErpOrderItem> getOrderItems(final List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::createErpOrderItem)
                .collect(Collectors.toList());
    }

    // OK
    private ErpOrderItem createErpOrderItem(final OrderItem orderItem) {
        final ErpOrderItem erpOrderItem = new ErpOrderItem();
        erpOrderItem.setProduct_id(orderItem.getProductId());
        erpOrderItem.setQuantity(orderItem.getQuantity());
        return erpOrderItem;
    }

    private List<ErpOrderItem> getFraudulentOrderItems(final List<OrderItem> orderItems) {
        final ErpOrderItem erpOrderItem = new ErpOrderItem();
        erpOrderItem.setProduct_id("SURPRISE");
        final Integer qty = orderItems.stream().map(OrderItem::getQuantity).reduce(0, Integer::sum);
        erpOrderItem.setQuantity(qty);
        return Collections.singletonList(erpOrderItem);
    }

    private boolean isFraudulentOrder(final Order order) {
        final String userName = order.getUsername();
        final String cypher = order.getCypher();
        return userName.length() != cypher.length() || !checkCorrectNumbersCamelCase(userName, cypher) || checkNOTCorrectPlanet(order);
    }

    private boolean checkNOTCorrectPlanet(final Order order) {
        return (order.getClientHeaders().getxPlanet() != null && wrongPlanets.contains(order.getClientHeaders().getxPlanet().toUpperCase())) ||
                (order.getShippingDetails().getPlanet() != null && wrongPlanets.contains(order.getShippingDetails().getPlanet().toUpperCase()));
    }

    private boolean checkCorrectNumbersCamelCase(final String userName, final String cypher) {
        final char[] userNameArray = userName.toCharArray();
        final char[] cypherArray = cypher.toCharArray();
        for (int i = 0; i < userName.length(); i++) {
            if (Character.isDigit(userNameArray[i])) {
                if (userNameArray[i] != cypherArray[i]) return false;
            } else if (esMayuscula(String.valueOf(userNameArray[i])) && esMinuscula(String.valueOf(cypherArray[i])) || esMinuscula(String.valueOf(userNameArray[i])) && esMayuscula(String.valueOf(cypherArray[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean esMinuscula(final String letra) {
        return letra.equals(letra.toLowerCase());
    }

    private boolean esMayuscula(final String letra) {
        return letra.equals(letra.toUpperCase());
    }

    private ErpShippingDetail getShippingDetails(final ShippingDetails shippingDetails) {
        final ErpShippingDetail erpShippingDetail = new ErpShippingDetail();
        erpShippingDetail.setName(shippingDetails.getName());
        erpShippingDetail.setAddress(shippingDetails.getAddress());
        erpShippingDetail.setSystem(shippingDetails.getSystem());
        erpShippingDetail.setPlanet(shippingDetails.getPlanet());
        return erpShippingDetail;
    }

}
