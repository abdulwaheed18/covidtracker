package com.waheedtechblog.covid.service;

import com.waheedtechblog.covid.domain.CovidResponse;
import com.waheedtechblog.covid.domain.DistrictWiseReport;
import com.waheedtechblog.covid.domain.StateCodes;
import com.waheedtechblog.covid.domain.StateWise;

import java.util.List;

public interface CovidService {

    public String getDayWiseRecord();

    public StateWise totalCases();

    public List<StateWise> getStateWiseCases();

    public List<StateCodes> getStateCodes();

    public DistrictWiseReport getStateCase(String stateCode);
}
