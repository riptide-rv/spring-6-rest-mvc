package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.model.Beer;
import com.example.spring6restmvc.model.Customer;
import com.example.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }
    @RequestMapping(value = "{customerID}",method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerID") UUID id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity handleOnPost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer"+savedCustomer.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }


}
