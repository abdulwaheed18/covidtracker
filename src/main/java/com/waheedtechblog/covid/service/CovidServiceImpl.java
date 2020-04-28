package com.waheedtechblog.covid.service;

import com.waheedtechblog.covid.domain.CovidResponse;
import com.waheedtechblog.covid.domain.StateCodes;
import com.waheedtechblog.covid.domain.StateWise;
import com.waheedtechblog.covid.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidServiceImpl implements CovidService {

    @Autowired
    private RestService restService;

    @Override
    public String getDayWiseRecord() {
        return null;
    }

    @Override
    public StateWise totalCases() {
        CovidResponse covidResponse = restService.exchange("data.json");
        for (StateWise stateWise : covidResponse.getStateWise()) {
            if (stateWise.getState().equals("Total"))
                return stateWise;
        }
        return new StateWise();
    }

    @Override
    public List<StateWise> getStateWiseCases() {
        CovidResponse covidResponse = restService.exchange("data.json");
        return covidResponse.getStateWise();
    }

    @Override
    public List<StateCodes> getStateCodes() {
        CovidResponse covidResponse = restService.exchange("data.json");
        List<StateCodes> stateCodes = new ArrayList<>();
        for (StateWise stateWise : covidResponse.getStateWise()) {
            StateCodes codes = new StateCodes();
            codes.setState(stateWise.getState());
            codes.setStateCode(stateWise.getStatecode());
            stateCodes.add(codes);
        }
        return stateCodes;
    }
}
