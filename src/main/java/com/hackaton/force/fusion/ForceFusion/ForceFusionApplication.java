package com.hackaton.force.fusion.ForceFusion;

import com.hackaton.force.fusion.ForceFusion.pojo.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ForceFusionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForceFusionApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate rt) throws Exception {

        for (int i = 1; i <= 10; i++) {
            final RestTemplate restTemplate = new RestTemplate();
            final ResponseEntity<Order> responseEntityOrder = restTemplate.getForEntity("http://ecommerce.hackathon.seidor.digital/orders/?page=1&per_page=" + i, Order.class);

            final Order order = responseEntityOrder.getBody();

            System.out.println(order);
        }


//		ResponseEntity<TokenResponse> response = restTemplate.postForEntity(getTokenUrl(), request, Order.class);
//		final TokenResponse tokenResponse = response.getBody();
//		if(tokenResponse != null) {
//			LOG.debug(tokenResponse.toString());
//			final String token = tokenResponse.getAccess_token();
//			baseStore.setSharepointToken(token);
//			getModelService().save(baseStore);
//			return token;
//		} else {
//			throw new IOException("Token cannot be obtained");
//		}

        return null;
    }
}
