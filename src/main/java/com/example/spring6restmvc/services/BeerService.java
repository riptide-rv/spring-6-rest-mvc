package com.example.spring6restmvc.services;

import com.example.spring6restmvc.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    public Optional<Beer> getBeerById(UUID id);
    public List<Beer> listBeers();

    Beer saveNewBeer(Beer beer);

    Beer updateById(UUID beerID, Beer beer);

    void deleteById(UUID beerid);
}
