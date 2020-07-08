package com.server.soap.webservices.customersadministration.soap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletRegistration;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    public ServletRegistration messageDispatcherServlet(ApplicationContext){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();

    }
}
