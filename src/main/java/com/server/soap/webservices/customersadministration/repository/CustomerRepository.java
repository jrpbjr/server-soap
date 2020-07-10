package com.server.soap.webservices.customersadministration.repository;

import com.server.soap.webservices.customersadministration.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {

}
