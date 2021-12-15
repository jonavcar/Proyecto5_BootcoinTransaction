package com.banck.bootcointransaction.spring.config;

import com.banck.bootcointransaction.infraestructure.repository.MovementCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.bootcointransaction.aplication.model.MovementRepository;
import com.banck.bootcointransaction.aplication.model.BctransactionRepository;
import com.banck.bootcointransaction.infraestructure.repository.BctransactionCrudRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public MovementRepository movementRepository() {
        return new MovementCrudRepository();
    }
    
    @Bean
    public BctransactionRepository bctransactionRepository() {
        return new BctransactionCrudRepository();
    }
}
