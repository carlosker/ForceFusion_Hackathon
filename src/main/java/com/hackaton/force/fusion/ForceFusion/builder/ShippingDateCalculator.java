package com.hackaton.force.fusion.ForceFusion.builder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="juancarlos.gonzalez@seidor.com">Juan Carlos González</a> on 7/7/23
 **/
public class ShippingDateCalculator {

    public static String calculateShippingDate(String orderDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(orderDate, formatter);

        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            date = date.plusDays(2);
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }

        LocalDate shippingDate = date.plusDays(2);

        if (shippingDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            shippingDate = shippingDate.plusDays(2);
        } else if (shippingDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            shippingDate = shippingDate.plusDays(1);
        }

        String monthValue = getMonthValue(shippingDate);
        String dayValue = getDayValue(shippingDate);
        return shippingDate.getYear() + "-" + monthValue + "-" + dayValue;
    }

    private static String getMonthValue(final LocalDate shippingDate) {
        String monthValue;
        if (shippingDate.getMonthValue() < 10) {
            monthValue = "0" + shippingDate.getMonthValue();
        } else {
            monthValue = String.valueOf(shippingDate.getMonthValue());
        }
        return monthValue;
    }

    private static String getDayValue(final LocalDate shippingDate) {
        String monthValue;
        if (shippingDate.getDayOfMonth() < 10) {
            monthValue = "0" + shippingDate.getDayOfMonth();
        } else {
            monthValue = String.valueOf(shippingDate.getDayOfMonth());
        }
        return monthValue;
    }

}
