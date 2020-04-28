package com.waheedtechblog.covid.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${covid.endpoint}")
    private String covidEndpoint;

    public <T> T exchange(String urlPath, Class<T> responseType) {
        return restTemplate.exchange(covidEndpoint + urlPath, HttpMethod.GET, null, responseType).getBody();
    }
}
