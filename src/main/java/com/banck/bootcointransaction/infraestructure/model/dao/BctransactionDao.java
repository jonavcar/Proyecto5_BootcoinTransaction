package com.banck.bootcointransaction.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("bctransaction")
public class BctransactionDao {

    @Id
    public String bctransaction;
    public double amount;
    public String modality;
    public String bankAccount;
    public String phoneNumber;
    public String hour;
    public String date;
    public String state;
}
