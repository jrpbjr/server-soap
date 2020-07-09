package com.server.soap.webservices.customersadministration.service;

import com.server.soap.webservices.customersadministration.bean.Customer;
import com.server.soap.webservices.customersadministration.helper.Status;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CustomerDetailService {
    private static List<Customer> customers = new ArrayList<>();

    static{
        Customer customer1 = new Customer(BigInteger.valueOf(1),"Bob", "99999999", "bob@gmail.com");
        customers.add(customer1);

        Customer customer2 = new Customer(BigInteger.valueOf(2),"Mark", "8888888", "mark@gmail.com");
        customers.add(customer2);

        Customer customer3 = new Customer(BigInteger.valueOf(3),"Jose", "7777777", "jose@gmail.com");
        customers.add(customer3);

        Customer customer4 = new Customer(BigInteger.valueOf(4),"Klay", "5555555", "klay@gmail.com");
        customers.add(customer4);


    }

    public Customer findById(BigInteger id){
        Optional <Customer> customerOptional = customers.stream().filter(c -> c.getId() == id).findAny();
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
    }

    public List<Customer> findAll(){
        return customers;
    }

    public Status deleteById(BigInteger id){
      Optional <Customer> customerOptional = customers.stream().filter(c -> c.getId() == id).findAny();
      if(customerOptional.isPresent()){
          customers.remove(customerOptional.get());
          return Status.SUCCESS;
      }
      return Status.FAILURE;
    }

}
