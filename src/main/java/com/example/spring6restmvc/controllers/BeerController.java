package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.model.Beer;
import com.example.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    @PostMapping
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping("{beerID}")
    public Beer getBeerById(@PathVariable("beerID") UUID id){
        return beerService.getBeerById(id);
    }



}
