/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.bootcointransaction.aplication.impl;

import com.banck.bootcointransaction.aplication.BctransactionOperations;
import com.banck.bootcointransaction.domain.Bctransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author jnacarra
 */
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final BctransactionOperations operations;

    @KafkaListener(topics = "topic-bctransaction", containerFactory = "bctransactionKafkaListenerContainerFactory")
    public void createBctransaction(Bctransaction Bctransaction) {
        Mono<ResponseService> rs = operations.create(Bctransaction);
        rs.subscribe(w -> {
            System.out.println(w.getMessage());
        });

    }

}
