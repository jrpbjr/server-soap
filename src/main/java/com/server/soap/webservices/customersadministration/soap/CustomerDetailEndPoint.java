package com.server.soap.webservices.customersadministration.soap;

import br.com.serversoap.CustomerDetail;
import br.com.serversoap.GetCustomerDetailRequest;
import br.com.serversoap.GetCustomerDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class CustomerDetailEndPoint {

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

}
