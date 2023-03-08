package com.example.spring6restmvc.services;

import com.example.spring6restmvc.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.*;

@Service

public class CustomerServiceImpl implements CustomerService {
    private Map<UUID,Customer> customerMap;
    public CustomerServiceImpl(){
        customerMap = new HashMap<>();
        Customer customer1 = Customer.builder()
                .customerName("first customer")
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .version(1)
                .lastModifiedDate(LocalDateTime.now())
                .build();
        Customer customer2 = Customer.builder()
                .customerName("second customer")
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .version(2)
                .lastModifiedDate(LocalDateTime.now())
                .build();
        Customer customer3 = Customer.builder()
                .customerName("third customer")
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .version(3)
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);
    }
    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }
}
