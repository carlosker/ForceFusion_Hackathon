package com.hackaton.force.fusion.ForceFusion;

import com.hackaton.force.fusion.ForceFusion.builder.ErpOrderBuilder;
import com.hackaton.force.fusion.ForceFusion.pojo.ErpOrder;
import com.hackaton.force.fusion.ForceFusion.pojo.Order;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ChallengeApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ChallengeApplication.class);
    public static final String HASH = "9e8fd1f07363c6bd00a4d9a9b45904e111aafa2eb3de8bcdccabf431eb2bdec1";
    public static final String POST_ERP_ORDER_URL = "http://erp.hackathon.seidor.digital/orders/2/";
    public static final String GET_URL_ORDERS = "http://ecommerce.hackathon.seidor.digital/orders/?page=";
    private final ErpOrderBuilder erpOrderBuilder = new ErpOrderBuilder();


    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            List<ErpOrder> erpOrderList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                final RestTemplate restTemplate = new RestTemplate();
                final ResponseEntity<Order[]> responseEntityOrder = restTemplate.getForEntity(GET_URL_ORDERS + i + "&per_page=10", Order[].class);
                final Order[] orders = responseEntityOrder.getBody();
                if (orders != null) {
                    erpOrderList.addAll(Arrays.stream(orders).map(erpOrderBuilder::buildErpOrderItem).collect(Collectors.toList()));
                }
            }

            final HttpHeaders headers = new HttpHeaders();
            headers.set("x-team-hash", HASH);
            erpOrderList.forEach(erpOrder -> {
                final RestTemplate restTemplate = new RestTemplate();
                final HttpEntity<ErpOrder> request = new HttpEntity<>(erpOrder, headers);
                final String URL = POST_ERP_ORDER_URL + erpOrder.getOrderId();
                ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
                LOG.info("ERP order:" + erpOrder);
                LOG.info("Response message: " + response.getBody());
            });
        };
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}