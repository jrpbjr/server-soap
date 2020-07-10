package com.server.soap.webservices.customersadministration.service;

import com.server.soap.webservices.customersadministration.bean.Customer;
import com.server.soap.webservices.customersadministration.helper.Status;
import com.server.soap.webservices.customersadministration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CustomerDetailService {

    /* private static List<Customer> customers = new ArrayList<>();


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
    */

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(BigInteger id){
        /*
        Optional <Customer> customerOptional = customers.stream().filter(c -> c.getId() == id).findAny();
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
         */
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
    }

    public List<Customer> findAll(){
        //return customers;
        return customerRepository.findAll();
    }

    public Status deleteById(BigInteger id){
       /*
      Optional <Customer> customerOptional = customers.stream().filter(c -> c.getId() == id).findAny();
      if(customerOptional.isPresent()){
          customers.remove(customerOptional.get());
          return Status.SUCCESS;
      }
      return Status.FAILURE;
        */
        try{
            customerRepository.deleteById(id);
            return Status.SUCCESS;
        }catch (Exception ex){
            return Status.FAILURE;
        }

    }

    public Status insert(Customer customer){
        /*
        customers.add(customer);
        return Status.SUCCESS;
        */
        try{
            customerRepository.save(customer);
            return Status.SUCCESS;
        }catch(Exception ex){
            return Status.FAILURE;
        }
    }


}
