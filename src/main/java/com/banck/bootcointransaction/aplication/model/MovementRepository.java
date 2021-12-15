package com.banck.bootcointransaction.aplication.model;

import com.banck.bootcointransaction.domain.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface MovementRepository {

    public Flux<Movement> list();

    public Mono<Movement> get(String movement);

    public Mono<Movement> create(Movement movement);

    public Mono<Movement> update(String id, Movement movement);

    public Flux<Movement> listByPhoneNumber(String phoneNumber);

    public void delete(String id);
}
