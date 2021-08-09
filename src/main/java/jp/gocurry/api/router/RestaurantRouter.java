package jp.gocurry.api.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import jp.gocurry.api.handler.RestaurantHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class RestaurantRouter {

	@Bean
	public RouterFunction<ServerResponse> route(RestaurantHandler restaurantHandler) {
		return RouterFunctions
				.route(GET("/healthcheck").and(accept(MediaType.TEXT_PLAIN)), restaurantHandler::healthcheck)
				.andRoute(GET("/restaurant/all").and(accept(MediaType.APPLICATION_JSON)),
						restaurantHandler::fetchAllRestaurants);
	}
}
