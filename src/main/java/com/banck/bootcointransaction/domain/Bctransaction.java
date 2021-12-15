package com.banck.bootcointransaction.domain;

import lombok.Data;

/**
 *
 * @author jonavcar
 */
@Data
public class Bctransaction {

    public String bctransaction;
    public double amount;
    public String modality;
    public String bankAccount;
    public String phoneNumber;
    public String hour;
    public String date;
    public String state;

}
