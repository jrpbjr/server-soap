package com.server.soap.webservices.customersadministration.soap;

import br.com.serversoap.*;
import com.server.soap.webservices.customersadministration.bean.Customer;
import com.server.soap.webservices.customersadministration.exception.CustomerNotFoundException;
import com.server.soap.webservices.customersadministration.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;
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
        Customer customer = service.findById(Integer.valueOf(req.getId().intValue()));
        if(customer == null){
            throw new CustomerNotFoundException("Invalid Customer id " + req.getId());
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

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "DeleteCustomerRequest")
    @ResponsePayload
    public DeleteCustomerResponse deleteCustomerRequest(@RequestPayload DeleteCustomerRequest req){
        DeleteCustomerResponse resp = new DeleteCustomerResponse();
        resp.setStatus(convertStatusSoap(service.deleteById(req.getId().intValue())));
        return resp;
    }

    private br.com.serversoap.Status convertStatusSoap(
            com.server.soap.webservices.customersadministration.helper.Status statusService){
        if(statusService == com.server.soap.webservices.customersadministration.helper.Status.FAILURE){
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

    @PayloadRoot(namespace = "http://serversoap.com.br", localPart = "InsertCustomerRequest")
    @ResponsePayload
    public InsertCustomerResponse insertCustomerRequest(@RequestPayload InsertCustomerRequest req){
        InsertCustomerResponse resp = new InsertCustomerResponse();
        resp.setStatus(convertStatusSoap(service.insert(convertCustomer(req.getCustomerDetail()))));
        return resp;
    }

    private Customer convertCustomer(CustomerDetail customerDetail){
        return new Customer(BigInteger.valueOf(customerDetail.getId().intValue())
                , customerDetail.getName()
                , customerDetail.getPhone()
                , customerDetail.getEmail());
    }

}
