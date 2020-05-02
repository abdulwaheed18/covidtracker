package com.waheedtechblog.covid.service;

import com.waheedtechblog.covid.domain.*;

import java.util.List;

/**
 * @Author AbdulWaheed18@gmail.com
 */
public interface CovidService {

    public String getDayWiseRecord();

    public StateWise totalCases();

    public List<StateWise> getStateWiseCases();

    public List<StateAndCityCodes> getStateAndCityCodes();

    public DistrictWiseReport getStateCase(String stateCode);

    public District getCityWiseCase(String stateCode, String cityName);
}
