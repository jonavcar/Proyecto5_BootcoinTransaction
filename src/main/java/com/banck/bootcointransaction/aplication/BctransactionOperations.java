package com.banck.bootcointransaction.aplication;

import com.banck.bootcointransaction.domain.Bctransaction;
import com.banck.bootcointransaction.aplication.impl.ResponseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface BctransactionOperations {

    public Flux<Bctransaction> list();

    public Mono<Bctransaction> get(String id);

    public Mono<ResponseService> create(Bctransaction Bctransaction); 

    public Mono<Bctransaction> update(String id, Bctransaction Bctransaction);

    public void delete(String id);

}
