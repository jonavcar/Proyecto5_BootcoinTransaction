package com.banck.bootcointransaction.aplication;

import com.banck.bootcointransaction.aplication.impl.ResponseService;
import com.banck.bootcointransaction.domain.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface MovementOperations {

    public Flux<Movement> list();

    public Mono<Movement> get(String movement);

    public Mono<ResponseService> create(Movement movement);

    public Mono<Movement> update(String id, Movement movement);
    
    public Mono<Double> saldo(String Bctransaction);

    public void delete(String id);
}
