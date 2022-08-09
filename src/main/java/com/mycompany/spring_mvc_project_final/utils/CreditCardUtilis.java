package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.CreditCardEntity;
import com.mycompany.spring_mvc_project_final.service.CreditCardService;

public class CreditCardUtilis {
    public static CreditCardEntity changeAmount(CreditCardEntity creditCardEntity, CreditCardService creditCardService, double cash){

        creditCardEntity.setBalance(creditCardEntity.getBalance()+cash);
        return creditCardEntity;
    }
}
