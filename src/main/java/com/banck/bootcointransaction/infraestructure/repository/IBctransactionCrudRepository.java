package com.banck.bootcointransaction.infraestructure.repository;

import com.banck.bootcointransaction.infraestructure.model.dao.BctransactionDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IBctransactionCrudRepository extends ReactiveCrudRepository<BctransactionDao, String> {

}
