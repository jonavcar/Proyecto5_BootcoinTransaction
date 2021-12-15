package com.banck.bootcointransaction.infraestructure.rest;

import com.banck.bootcointransaction.domain.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.bootcointransaction.aplication.MovementOperations;
import com.banck.bootcointransaction.utils.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/bctransaction")
@RequiredArgsConstructor
public class MovementController {

    private final MovementOperations operations;

    @GetMapping
    public Flux<Movement> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Movement> get(@PathVariable("id") String id) {
        return operations.get(id);
    }


    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Movement rqMovement) {
        return operations.create(rqMovement).flatMap(w -> {
            if (w.getStatus() == Status.OK) {
                return Mono.just(new ResponseEntity(w.getData(), HttpStatus.OK));
            }
            return Mono.just(new ResponseEntity(w.getMessage(), HttpStatus.BAD_REQUEST));
        });
    }

    @PutMapping("/{id}")
    public Mono<Movement> update(@PathVariable("id") String id, @RequestBody Movement movement) {
        return operations.update(id, movement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }
}
