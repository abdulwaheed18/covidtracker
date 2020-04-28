package com.waheedtechblog.covid.service;

import com.waheedtechblog.covid.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidServiceImpl implements CovidService{

    @Autowired
    private RestService restService;

    @Override
    public String getDayWiseRecord() {
        return restService.exchange("data.json");
    }
}
