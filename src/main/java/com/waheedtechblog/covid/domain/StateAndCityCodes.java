package com.waheedtechblog.covid.domain;

import java.util.HashSet;
import java.util.Set;

public class StateAndCityCodes {

    private String state;
    private String stateCode;
    private Set<String> cityCodes;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Set<String> getCityCodes() {
        if(cityCodes == null)
            cityCodes = new HashSet<>();
        return cityCodes;
    }

    public void setCityCodes(Set<String> cityCodes) {
        this.cityCodes = cityCodes;
    }
}
