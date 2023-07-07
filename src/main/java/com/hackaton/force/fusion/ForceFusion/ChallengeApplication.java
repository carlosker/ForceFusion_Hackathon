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

    private static final Logger log = LoggerFactory.getLogger(ChallengeApplication.class);
    private final ErpOrderBuilder erpOrderBuilder = new ErpOrderBuilder();


    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {

            List<ErpOrder> erpOrderList = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                final RestTemplate restTemplate = new RestTemplate();
                final ResponseEntity<Order[]> responseEntityOrder = restTemplate.getForEntity("http://ecommerce.hackathon.seidor.digital/orders/?page=" + i + "&per_page=10", Order[].class);

                final Order[] orders = responseEntityOrder.getBody();

                if (orders != null) {
                    erpOrderList.addAll(Arrays.stream(orders).map(erpOrderBuilder::buildErpOrderItem).collect(Collectors.toList()));
                }
            }

            final HttpHeaders headers = new HttpHeaders();
            headers.set("x-team-hash", "9e8fd1f07363c6bd00a4d9a9b45904e111aafa2eb3de8bcdccabf431eb2bdec1");

            erpOrderList.forEach(erpOrder -> {

                if (erpOrder.getOrderId().equals("SEIDOR_GO_001") || erpOrder.getOrderId().equals("SEIDOR_GO_002")) {
                    final RestTemplate restTemplate = new RestTemplate();

                    final HttpEntity<ErpOrder> request = new HttpEntity<>(erpOrder, headers);
                    final String URL = "http://erp.hackathon.seidor.digital/orders/2/" + erpOrder.getOrderId();
                    ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
                    System.out.println("ERP order id:" + erpOrder.getOrderId());
                    System.out.println("ERP order:" + erpOrder);
                    System.out.println("Status code: " + response.getStatusCode());
                    System.out.println("Response status: " + response.getBody());
                }

            });

        };
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}