package com.banck.bootcointransaction.aplication.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.bootcointransaction.domain.Bctransaction;
import com.banck.bootcointransaction.utils.Status;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.banck.bootcointransaction.aplication.BctransactionOperations;
import com.banck.bootcointransaction.aplication.model.BctransactionRepository;
import com.banck.bootcointransaction.utils.StateTransacction;
import java.util.UUID;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class BctransactionOperationsImpl implements BctransactionOperations {

    Logger logger = LoggerFactory.getLogger(BctransactionOperationsImpl.class);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/Bogota"));

    private final BctransactionRepository bctransactionRepository;
    public ResponseService responseService;

    @Override
    public Flux<Bctransaction> list() {
        return bctransactionRepository.list();
    }

    @Override
    public Mono<Bctransaction> get(String Bctransaction) {
        return bctransactionRepository.get(Bctransaction);
    }

    @Override
    public Mono<ResponseService> create(Bctransaction Bctransaction) {
        return validateDataBctransactionToCreate(Bctransaction).flatMap(RS -> {
            responseService = RS;
            if (responseService.getStatus() == Status.OK) {
                return insertBctransaction(Bctransaction);
            } else {
                return Mono.just(responseService);
            }
        });
    }

    @Override
    public Mono<Bctransaction> update(String Bctransaction, Bctransaction c) {
        return bctransactionRepository.update(Bctransaction, c);
    }

    @Override
    public void delete(String Bctransaction) {
        bctransactionRepository.delete(Bctransaction);
    }

    public Mono<ResponseService> insertBctransaction(Bctransaction Bctransaction) {
        responseService = new ResponseService();
        Bctransaction.setBankAccount(UUID.randomUUID().toString());
        Bctransaction.setDate(dateTime.format(formatDate));
        Bctransaction.setHour(dateTime.format(formatTime));
        Bctransaction.setState(StateTransacction.CREATED.toString());
        return bctransactionRepository.create(Bctransaction).flatMap(w -> {
            responseService.setStatus(Status.OK);
            responseService.setData(w);
            return Mono.just(responseService);
        });
    }

    public Mono<ResponseService> validateDataBctransactionToCreate(Bctransaction bctransaction) {
        responseService = new ResponseService();
        responseService.setStatus(Status.ERROR);

        if (!Optional.ofNullable(bctransaction.getAmount()).isPresent() || bctransaction.getAmount() < 0) {
            responseService.setMessage("Debe el monto y no debe ser 0");
            return Mono.just(responseService);
        }
        if (!Optional.ofNullable(bctransaction.getModality()).isPresent()) {
            responseService.setMessage("Debe la modalidad");
            return Mono.just(responseService);
        }
        if (bctransaction.getModality().equals("YANKI")) {
            if (!Optional.ofNullable(bctransaction.getPhoneNumber()).isPresent() || bctransaction.getPhoneNumber().length() < 9) {
                responseService.setMessage("Debe ingresar numero de telefono y debe ser mayor igual a 9 numeros");
                return Mono.just(responseService);

            }
        } else {
            if (!Optional.ofNullable(bctransaction.getBankAccount()).isPresent()) {
                responseService.setMessage("Debe ingresar la cuenta bancaria");
                return Mono.just(responseService);
            }
        }

        responseService.setStatus(Status.OK);
        responseService.setData(bctransaction);
        return Mono.just(responseService);
    }
}
