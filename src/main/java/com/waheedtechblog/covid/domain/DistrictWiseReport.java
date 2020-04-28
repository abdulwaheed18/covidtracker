package com.waheedtechblog.covid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DistrictWiseReport {

    @JsonProperty("districtData")
    private Map<String, District> districts = new HashMap<>();
    private String statecode;

    public Map<String, District> getDistricts() {
        return districts;
    }

    public void setDistricts(Map<String, District> districts) {
        this.districts = districts;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }
}
