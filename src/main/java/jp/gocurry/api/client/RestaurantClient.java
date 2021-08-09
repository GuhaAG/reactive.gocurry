package jp.gocurry.api.client;

import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jp.gocurry.api.model.Restaurant;

@Component
public class RestaurantClient {

	private final WebClient client;

	public RestaurantClient(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public Mono<String> getHealthcheck() {
		return this.client.get().uri("/healthcheck").accept(MediaType.TEXT_PLAIN).retrieve().bodyToMono(String.class);
	}

	public Mono<Restaurant> getAllRestaurants() {
		return this.client.get().uri("/restaurants/all").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Restaurant.class);
	}
}
