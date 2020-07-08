package com.server.soap.webservices.customersadministration.soap;

import br.com.serversoap.GetCustomerDetailRequest;
import br.com.serversoap.GetCustomerDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class CustomerDetailEndPoint {

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "GetCustomerDetailRequest")
    public GetCustomerDetailResponse processCustomerDetailRequest(GetCustomerDetailRequest req){
        GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        return response;
    }

}
