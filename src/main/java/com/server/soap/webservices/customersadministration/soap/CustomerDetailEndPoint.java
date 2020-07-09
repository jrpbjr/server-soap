package com.server.soap.webservices.customersadministration.soap;

import br.com.serversoap.CustomerDetail;
import br.com.serversoap.GetCustomerDetailRequest;
import br.com.serversoap.GetCustomerDetailResponse;
import com.server.soap.webservices.customersadministration.bean.Customer;
import com.server.soap.webservices.customersadministration.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class CustomerDetailEndPoint {

    @Autowired
    CustomerDetailService service;

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest req){
        GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(BigInteger.valueOf(1));
        customerDetail.setName("Bob");
        customerDetail.setPhone("99999999");
        customerDetail.setEmail("bob@gmail.com.br");
        return response;
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

}
