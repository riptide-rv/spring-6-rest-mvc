package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.model.Beer;
import com.example.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("{beerID}")
    public Beer getBeerById(@PathVariable("beerID") UUID id){
        return beerService.getBeerById(id).orElseThrow(NotFoundException::new);
    }
    @PutMapping("{beerid}")
    public ResponseEntity updateById(@PathVariable("beerid") UUID beerID,@RequestBody Beer beer){
        Beer updatedBeer = beerService.updateById(beerID,beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping("{beerid}")
    public ResponseEntity deleteById(@PathVariable("beerid") UUID beerid){
        beerService.deleteById(beerid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
