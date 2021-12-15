package com.banck.bootcointransaction.aplication.model;

import com.banck.bootcointransaction.domain.Bctransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface BctransactionRepository {

    public Flux<Bctransaction> list();

    public Mono<Bctransaction> get(String id);

    public Mono<Bctransaction> create(Bctransaction d);

    public Mono<Bctransaction> update(String id, Bctransaction d);

    public void delete(String id);
}
