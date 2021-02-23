package com.leet.buk.Adyen;

import lombok.Value;

import java.math.BigDecimal;
//import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    /*private SoldProduct getProductInEur(SoldProduct product) {
        Optional<BigDecimal> exchangeRate = exchangeService.rate(product.getCurrency());
        if(exchangeRate !=null && exchangeRate.isPresent()){
            return product.getPrice().multiply(exchangeRate.get());
        }
    }*/
/*
    SoldProductsAggregate aggregate2(Stream<SoldProduct> products) {
        Supplier<Stream<SoldProduct>> streamSupplier = filterStream(products);
        List<SimpleSoldProduct> sp = streamSupplier.get().map(p-> new SimpleSoldProduct(p.getName(), p.getPrice()) ).collect(Collectors.toList());
        BigDecimal bd = streamSupplier.get().map(p -> getRate(p)).reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SoldProductsAggregate(sp, bd);
    }*/

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        Supplier<Stream<SoldProduct>> streamSupplier = filterStream(products);
        List<SimpleSoldProduct> sp = streamSupplier.get().map(p-> new SimpleSoldProduct(p.getName(), p.getPrice()) ).collect(Collectors.toList());
        BigDecimal bd = streamSupplier.get().map(p-> getRate(p)).reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SoldProductsAggregate(sp, bd);
    }


    private boolean isProductHaveExchangeValue(SoldProduct product) {
        Optional<BigDecimal> exchangeRate = exchangeService.rate(product.getCurrency());
        return exchangeRate == null || !exchangeRate.isPresent() || exchangeRate.get().compareTo(BigDecimal.ZERO) < 0;
    }


    private BigDecimal getRate(SoldProduct product) {
        Optional<BigDecimal> exchangeRate = exchangeService.rate(product.getCurrency());
        return product.getPrice().multiply(exchangeRate.get()); // we have already filtered other cases
    }

    private Supplier<Stream<SoldProduct>> filterStream(Stream<SoldProduct> products) {
        if(products == null ){
            return () -> Stream.empty();
        }
        List<SoldProduct> prods = products.filter(p-> !isProductHaveExchangeValue(p)).collect(Collectors.toList());
        return () -> prods.stream();
    }




    public static void main(String[] args) {
        EURExchangeService eur = new EURExchangeService();
        SoldProductsAggregator aggregator = new SoldProductsAggregator(eur);
        List<SoldProduct> sp = new ArrayList<>();
        sp.add(new SoldProduct("p1", new BigDecimal(100), "USD"));
        sp.add(new SoldProduct("p1", new BigDecimal(100), "PD"));
        sp.add(new SoldProduct("p1", new BigDecimal(100), "AUD"));
        sp.add(new SoldProduct("p1", new BigDecimal(100), "INR"));
        sp.add(new SoldProduct("p1", new BigDecimal(100), "EUR"));
        Stream<SoldProduct> products = sp.stream();
        System.out.println(aggregator.aggregate(sp.stream()).getTotal());
        //aggregator.aggregate(products);
        //aggregator.aggregate(null);
        System.out.println(aggregator.aggregate(null).getTotal());
        List<SoldProduct> sp2 = new ArrayList<>();
        sp.add(new SoldProduct("p1", new BigDecimal(100), "EUR"));
        sp.add(new SoldProduct("p1", new BigDecimal(100), "EUR"));
        System.out.println(aggregator.aggregate(sp2.stream()).getTotal());
    }






}

@Value
class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}

@Value
class SimpleSoldProduct {
    String name;
    BigDecimal price;
}

@Value
class SoldProduct {
    String name;
    BigDecimal price;
    String currency;
}

