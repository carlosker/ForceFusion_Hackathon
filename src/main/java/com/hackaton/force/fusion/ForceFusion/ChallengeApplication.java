package com.hackaton.force.fusion.ForceFusion;

import com.coding.challenge.repository.CartEntryRepository;
import com.coding.challenge.repository.CartRepository;
import com.coding.challenge.repository.ProductRepository;
import com.hackaton.force.fusion.ForceFusion.pojo.Order;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChallengeApplication {

    private static final Logger log = LoggerFactory.getLogger(ChallengeApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {

            for (int i = 1; i <= 10; i++) {
                final RestTemplate restTemplate = new RestTemplate();
                final ResponseEntity<Order> responseEntityOrder = restTemplate.getForEntity("http://ecommerce.hackathon.seidor.digital/orders/?page=1&per_page=" + i, Order.class);

                final Order order = responseEntityOrder.getBody();

                System.out.println(order);
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}