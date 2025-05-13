package kz.g134.FlightTicketsShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlightTicketsShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTicketsShopApplication.class, args);
	}

}
