package jp.gocurry.api.service;

import org.springframework.stereotype.Service;

import jp.gocurry.api.model.Restaurant;
import jp.gocurry.api.repository.RestaurantRepository;
import reactor.core.publisher.Flux;

@Service
public class RestaurantService {

	private final RestaurantRepository repository;

	public RestaurantService(RestaurantRepository repository) {
		this.repository = repository;
	}

	public Flux<Restaurant> findAllRestaurants() {
		return repository.findAll();
	}
}
