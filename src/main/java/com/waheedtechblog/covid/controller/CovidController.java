package com.waheedtechblog.covid.controller;

import com.waheedtechblog.covid.domain.DistrictWiseReport;
import com.waheedtechblog.covid.domain.StateCodes;
import com.waheedtechblog.covid.domain.StateWise;
import com.waheedtechblog.covid.service.CovidService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Endpoint to access covid 19 records")
public class CovidController {

    @Autowired
    private CovidService covidService;

    @GetMapping("/totalCases")
    @ApiOperation(value = "Total number of cases in India", response = String.class, produces = "application/json")
    public ResponseEntity<StateWise> totalCases(){
        return ResponseEntity.ok(covidService.totalCases());
    }

    @GetMapping("/stateWise")
    @ApiOperation(value = "State wise test Cases", response = String.class, produces = "application/json")
    public ResponseEntity<List<StateWise>> stateWise(){
        return ResponseEntity.ok(covidService.getStateWiseCases());
    }

    @GetMapping("/stateWise/{id}")
    @ApiOperation(value = "Cases specific to state", response = String.class, produces = "application/json")
    public ResponseEntity<DistrictWiseReport> stateWise(@ApiParam(value = "State Code", required=true, defaultValue = "MH") @PathVariable String id){
        return ResponseEntity.ok(covidService.getStateCase(id));
    }

    @GetMapping("/stateCode")
    @ApiOperation(value = "List of state Code", response = String.class, produces = "application/json")
    public ResponseEntity<List<StateCodes>> getStateCode(){
        return ResponseEntity.ok(covidService.getStateCodes());
    }
}
