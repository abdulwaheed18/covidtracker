package com.waheedtechblog.covid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CovidResponse {

    @JsonProperty("cases_time_series")
    List<TimeSeriesCases> timeSeriesCases = new ArrayList<>();

    @JsonProperty("statewise")
    List<StateWise> stateWise = new ArrayList<>();

    @JsonProperty("tested")
    List<TestedCase> testedCases = new ArrayList<>();

    public List<TimeSeriesCases> getTimeSeriesCases() {
        return timeSeriesCases;
    }

    public void setTimeSeriesCases(List<TimeSeriesCases> timeSeriesCases) {
        this.timeSeriesCases = timeSeriesCases;
    }

    public List<StateWise> getStateWise() {
        return stateWise;
    }

    public void setStateWise(List<StateWise> stateWise) {
        this.stateWise = stateWise;
    }

    public List<TestedCase> getTestedCases() {
        return testedCases;
    }

    public void setTestedCases(List<TestedCase> testedCases) {
        this.testedCases = testedCases;
    }
}
