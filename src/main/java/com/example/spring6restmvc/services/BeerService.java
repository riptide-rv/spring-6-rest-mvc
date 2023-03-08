package com.example.spring6restmvc.services;

import com.example.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    public Beer getBeerById(UUID id);
    public List<Beer> listBeers();
}
