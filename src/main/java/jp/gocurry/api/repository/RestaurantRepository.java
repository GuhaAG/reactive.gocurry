package jp.gocurry.api.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import jp.gocurry.api.model.Restaurant;
import reactor.core.publisher.Flux;

public interface RestaurantRepository extends ReactiveCrudRepository<Restaurant, Long> {

	@Query("SELECT * FROM restaurant WHERE name = :name OR name_jp = :name")
	Flux<Restaurant> findByName(String name);
}
