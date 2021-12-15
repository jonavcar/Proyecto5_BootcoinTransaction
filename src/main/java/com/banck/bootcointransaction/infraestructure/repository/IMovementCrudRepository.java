package com.banck.bootcointransaction.infraestructure.repository;

import com.banck.bootcointransaction.infraestructure.model.dao.MovementDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IMovementCrudRepository extends ReactiveCrudRepository<MovementDao, String> {

    Flux<MovementDao> findAllByProduct(String product); 

    Flux<MovementDao> findAllByCustomer(String customer);

    Flux<MovementDao> findAllByCustomerAndProduct(String customer, String product);
}
