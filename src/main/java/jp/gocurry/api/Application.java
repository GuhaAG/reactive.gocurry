package jp.gocurry.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.gocurry.api.client.RestaurantClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		RestaurantClient restaurantClient = context.getBean(RestaurantClient.class);
		// We need to block for the content here or the JVM might exit before the
		// message is logged
		System.out.println(">> " + restaurantClient.getHealthcheck().block());
	}
}