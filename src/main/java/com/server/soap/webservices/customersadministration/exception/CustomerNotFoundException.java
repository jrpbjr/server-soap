package com.server.soap.webservices.customersadministration.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CustomerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
