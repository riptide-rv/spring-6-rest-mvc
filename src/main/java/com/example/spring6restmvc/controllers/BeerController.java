package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.model.Beer;
import com.example.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping("{beerID}")
    public Beer getBeerById(@PathVariable("beerID") UUID id){
        return beerService.getBeerById(id);
    }


}
