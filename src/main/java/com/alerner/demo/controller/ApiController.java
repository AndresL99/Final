package com.alerner.demo.controller;

import com.alerner.demo.api.Covid19;
import com.alerner.demo.service.Covid19CountriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/covid19Api")
public class ApiController
{

    private Covid19CountriesService covid19CountriesService;


    public ApiController(Covid19CountriesService covid19CountriesService) {
        this.covid19CountriesService = covid19CountriesService;
    }


    @GetMapping("/getCountries")
    public ResponseEntity<List<Covid19>> getCovidData() throws IOException, InterruptedException {
        return ResponseEntity.ok(covid19CountriesService.getDataOfApi());
    }

}
