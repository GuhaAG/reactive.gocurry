package jp.gocurry.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import jp.gocurry.api.model.Restaurant;
import jp.gocurry.api.service.RestaurantService;
import reactor.core.publisher.Mono;

@Component
public class RestaurantHandler {

	@Autowired
	RestaurantService restaurantService;

	public Mono<ServerResponse> healthcheck(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromValue(new String("apis online")));
	}

	public Mono<ServerResponse> fetchAllRestaurants(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(restaurantService.findAllRestaurants(),Restaurant.class);
	}
}
