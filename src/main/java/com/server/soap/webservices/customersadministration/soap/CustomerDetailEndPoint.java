package com.server.soap.webservices.customersadministration.soap;

import br.com.serversoap.*;
import com.server.soap.webservices.customersadministration.bean.Customer;
import com.server.soap.webservices.customersadministration.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CustomerDetailEndPoint {

    @Autowired
    CustomerDetailService service;

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest req) throws Exception {
       /* GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(BigInteger.valueOf(1));
        customerDetail.setName("Bob");
        customerDetail.setPhone("99999999");
        customerDetail.setEmail("bob@gmail.com.br");*/
        Customer customer = service.findById(req.getId());
        if(customer == null){
            throw new Exception("Invalid Customer id" + req.getId());
        }

        //return response;
        return convertToCustomerDetailResponse(customer);
    }

    private GetCustomerDetailResponse convertToCustomerDetailResponse(Customer customer){
        GetCustomerDetailResponse resp = new GetCustomerDetailResponse();
        resp.setCustomerDetail(convertToCustomerDetail(customer));
        return resp;
    }

    private CustomerDetail convertToCustomerDetail(Customer customer){
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(customer.getId());
        customerDetail.setName(customer.getName());
        customerDetail.setPhone(customer.getPhone());
        customerDetail.setEmail(customer.getEmail());
        return customerDetail;
    }

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "GetAllCustomerDetailRequest")
    @ResponsePayload
    public GetAllCustomerDetailResponse processGetAllCustomerDetailResponse(@RequestPayload GetAllCustomerDetailRequest req){
        List<Customer> customers = service.findAll();
        return convertToGetAllCustomerDetailResponse(customers);
    }

    private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(List<Customer> customers){
        GetAllCustomerDetailResponse resp = new GetAllCustomerDetailResponse();
        customers.stream().forEach(c -> resp.getCustomerDetail().add(convertToCustomerDetail(c)));
        return resp;
    }

}
