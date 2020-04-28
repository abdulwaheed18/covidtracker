package com.waheedtechblog.covid.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StateWiseDetailReport {

    Map<String,DistrictWiseReport> districtWiseReport = new HashMap<>();

    public Map<String, DistrictWiseReport> getDistrictWiseReport() {
        return districtWiseReport;
    }

    public void setDistrictWiseReport(Map<String, DistrictWiseReport> districtWiseReport) {
        this.districtWiseReport = districtWiseReport;
    }
}
