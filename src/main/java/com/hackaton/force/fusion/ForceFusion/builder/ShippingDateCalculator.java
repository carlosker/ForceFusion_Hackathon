package com.hackaton.force.fusion.ForceFusion.builder;

import java.text.SimpleDateFormat;
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

        // Verificar si la fecha calculada cae en un fin de semana (sábado o domingo)
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            // Si es sábado, agregar 2 días para ajustarlo al próximo día hábil (lunes)
            date = date.plusDays(2);
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            // Si es domingo, agregar 1 día para ajustarlo al próximo día hábil (lunes)
            date = date.plusDays(1);
        }

        // Agregar 3 días a la fecha del pedido
        LocalDate shippingDate = date.plusDays(2);

        // Verificar si la fecha calculada cae en un fin de semana (sábado o domingo)
        if (shippingDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            // Si es sábado, agregar 2 días para ajustarlo al próximo día hábil (lunes)
            shippingDate = shippingDate.plusDays(2);
        } else if (shippingDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            // Si es domingo, agregar 1 día para ajustarlo al próximo día hábil (lunes)
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
