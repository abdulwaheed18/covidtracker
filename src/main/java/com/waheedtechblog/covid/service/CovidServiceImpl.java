package com.waheedtechblog.covid.service;

import com.waheedtechblog.covid.domain.*;
import com.waheedtechblog.covid.rest.RestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        CovidResponse covidResponse = restService.exchange("data.json", CovidResponse.class);
        for (StateWise stateWise : covidResponse.getStateWise()) {
            if (stateWise.getState().equals("Total"))
                return stateWise;
        }
        return new StateWise();
    }

    @Override
    public List<StateWise> getStateWiseCases() {
        CovidResponse covidResponse = restService.exchange("data.json", CovidResponse.class);
        return covidResponse.getStateWise();
    }

    @Override
    public List<StateCodes> getStateCodes() {
        CovidResponse covidResponse = restService.exchange("data.json", CovidResponse.class);
        List<StateCodes> stateCodes = new ArrayList<>();
        for (StateWise stateWise : covidResponse.getStateWise()) {
            StateCodes codes = new StateCodes();
            codes.setState(stateWise.getState());
            codes.setStateCode(stateWise.getStatecode());
            stateCodes.add(codes);
        }
        return stateCodes;
    }

    @Override
    public DistrictWiseReport getStateCase(String stateCode) {
        String covidResponse = restService.exchange("state_district_wise.json", String.class);

        StateWiseDetailReport stateWiseDetailReport = getStateWiseDetailReport(covidResponse);
        for(String state : stateWiseDetailReport.getDistrictWiseReport().keySet()){
            DistrictWiseReport districtWiseReport = stateWiseDetailReport.getDistrictWiseReport().get(state);
            if(districtWiseReport.getStatecode().equals(stateCode)){
                return districtWiseReport;
            }
        }
        return null;
    }

    @Override
    public District getCityWiseCase(String stateCode, String cityName) {
        String covidResponse = restService.exchange("state_district_wise.json", String.class);

        StateWiseDetailReport stateWiseDetailReport = getStateWiseDetailReport(covidResponse);
        for(String state : stateWiseDetailReport.getDistrictWiseReport().keySet()){
            DistrictWiseReport districtWiseReport = stateWiseDetailReport.getDistrictWiseReport().get(state);
            if(districtWiseReport.getStatecode().equals(stateCode)){
               for(String city : districtWiseReport.getDistricts().keySet()){
                   if(city.equalsIgnoreCase(cityName)){
                       return districtWiseReport.getDistricts().get(city);
                   }
               }
            }
        }
        return null;
    }

    private StateWiseDetailReport getStateWiseDetailReport(String covidResponse){
        StateWiseDetailReport stateWiseDetailReport = new StateWiseDetailReport();
        Map<String,DistrictWiseReport> districtWiseReportMap = new HashMap<>();

        JSONObject root = new JSONObject(covidResponse);
        Map<String, Object> states = root.toMap();

        //list of states
        for (String state : states.keySet()) {

            Map<String, Object> districtData = (Map<String, Object>) states.get(state);
            Map<String, District> districtMap = new HashMap<>();
            DistrictWiseReport districtWiseReport = new DistrictWiseReport();

            for( String district : districtData.keySet()){

                Map<String, Object> dist = null;
                if(district.equals("statecode")) {
                    districtWiseReport.setStatecode((String) districtData.get(district));
                    continue;
                } else {
                    dist =(Map<String, Object>)districtData.get(district);
                }

                for(String city : dist.keySet()){
                    HashMap<String,Integer> localDistrict = (HashMap<String, Integer>) dist.get(city);

                    District district1 = new District();
                    for(String key : localDistrict.keySet()){
                        if(key.equals("active")){
                            district1.setActive(localDistrict.get(key));
                        } else if(key.equals("confirmed")){
                            district1.setConfirmed(localDistrict.get(key));
                        } else if(key.equals("deceased")){
                            district1.setDeceased(localDistrict.get(key));
                        } else if(key.equals("recovered")){
                            district1.setRecovered(localDistrict.get(key));
                        }
                    }
                    districtMap.put(city,district1);
                }
                districtWiseReport.setDistricts(districtMap);
                districtWiseReportMap.put(state,districtWiseReport);
            }
            stateWiseDetailReport.setDistrictWiseReport(districtWiseReportMap);
        }
        return  stateWiseDetailReport;
    }
}
