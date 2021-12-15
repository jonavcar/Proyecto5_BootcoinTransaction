package com.banck.bootcointransaction.infraestructure.repository;

import com.banck.bootcointransaction.domain.Bctransaction;
import com.banck.bootcointransaction.infraestructure.model.dao.BctransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.bootcointransaction.aplication.model.BctransactionRepository;

/**
 *
 * @author jonavcar
 */
@Component
public class BctransactionCrudRepository implements BctransactionRepository {

    @Autowired
    IBctransactionCrudRepository crudRepository;

    @Override
    public Mono<Bctransaction> get(String debitcardaccount) {
        return crudRepository.findById(debitcardaccount).map(this::BctransactionDaoToBctransaction);
    }

    @Override
    public Flux<Bctransaction> list() {
        return crudRepository.findAll().map(this::BctransactionDaoToBctransaction);
    }

    @Override
    public Mono<Bctransaction> create(Bctransaction debitcardaccount) {
        return crudRepository.save(BctransactionToBctransactionDao(debitcardaccount)).map(this::BctransactionDaoToBctransaction);
    }

    @Override
    public Mono<Bctransaction> update(String debitcardaccount, Bctransaction c) {
        return crudRepository.save(BctransactionToBctransactionDao(c)).map(this::BctransactionDaoToBctransaction);
    }

    @Override
    public void delete(String debitcardaccount) {
        crudRepository.deleteById(debitcardaccount).subscribe();
    }

    public Bctransaction BctransactionDaoToBctransaction(BctransactionDao md) {
        Bctransaction m = new Bctransaction();
        m.setBctransaction(md.getBctransaction());
        m.setBankAccount(md.getBankAccount());
        m.setModality(md.getModality());
        m.setPhoneNumber(md.getPhoneNumber());
        m.setAmount(md.getAmount());
        m.setHour(md.getHour());
        m.setDate(md.getDate());
        m.setState(md.getState());
        return m;
    }

    public BctransactionDao BctransactionToBctransactionDao(Bctransaction p) {
        BctransactionDao pd = new BctransactionDao();
        pd.setBctransaction(p.getBctransaction());
        pd.setBankAccount(p.getBankAccount());
        pd.setModality(p.getModality());
        pd.setPhoneNumber(p.getPhoneNumber());
        pd.setAmount(p.getAmount());
        pd.setHour(p.getHour());
        pd.setDate(p.getDate());
        pd.setState(p.getState());
        return pd;
    }

}
