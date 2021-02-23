package com.leet.buk.Adyen;

import java.math.BigDecimal;
import java.util.Optional;

public class EURExchangeService {
    public Optional<BigDecimal> rate(String currency) {

        if(currency.equalsIgnoreCase( "USD")){
            return Optional.of(new BigDecimal(0.90));
        }if(currency.equalsIgnoreCase( "INR")){
            return Optional.of(new BigDecimal(.50));
        }
        if(currency.equalsIgnoreCase( "AUD")){
            return Optional.of(new BigDecimal(0.80));
        }
        if(currency.equalsIgnoreCase( "PD")){
            return Optional.of(new BigDecimal(-1));
        }
        else{
            return null;
        }

        /**
         * sp.add(new SoldProduct("p1", new BigDecimal(100), "USD"));
         *         sp.add(new SoldProduct("p1", new BigDecimal(100), "PD"));
         *         sp.add(new SoldProduct("p1", new BigDecimal(100), "AUD"));
         *         sp.add(new SoldProduct("p1", new BigDecimal(100), "INR"));
         *         sp.add(new SoldProduct("p1", new BigDecimal(100), "EUR"));
         */
    }
}
