package com.example.spring6restmvc.services;

import com.example.spring6restmvc.model.Beer;
import com.example.spring6restmvc.model.BeerStyle;
import org.springframework.expression.spel.ast.BeanReference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service

public class BeerServiceImpl implements BeerService {
    private Map<UUID,Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("first beer")
                .beerStyle(BeerStyle.PILSNER)
                .upc("111111")
                .version(1)
                .price(new BigDecimal("10.01"))
                .quantityOnHand(10)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("second beer")
                .beerStyle(BeerStyle.LAGER)
                .upc("222222")
                .version(2)
                .price(new BigDecimal("20.02"))
                .quantityOnHand(20)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("third beer")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("333333")
                .version(3)
                .price(new BigDecimal("30.03"))
                .quantityOnHand(30)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        beerMap.put(beer1.getId(),beer1);
        beerMap.put(beer2.getId(),beer2);
        beerMap.put(beer3.getId(),beer3);
    }
    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .version(beer.getVersion())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .quantityOnHand(beer.getQuantityOnHand())
                .price(beer.getPrice())
                .build();
        beerMap.put(savedBeer.getId(),savedBeer);
        return savedBeer;
    }

    @Override
    public Beer getBeerById(UUID id) {
        return beerMap.get(id);
    }
}
