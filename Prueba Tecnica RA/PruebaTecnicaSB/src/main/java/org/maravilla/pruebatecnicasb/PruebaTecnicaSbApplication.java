package org.maravilla.pruebatecnicasb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@Configuration
@SpringBootApplication
public class PruebaTecnicaSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaSbApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}


