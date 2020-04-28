package com.waheedtechblog.covid.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${covid.endpoint}")
    private String covidEndpoint;

    public String exchange(String urlPath) {
        return restTemplate.exchange(covidEndpoint + urlPath, HttpMethod.GET, null, String.class).getBody();
    }


}
