package com.alerner.demo.service;

import com.alerner.demo.api.ApiCovid19;
import com.alerner.demo.api.Covid19;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Covid19CountriesService
{
    @Autowired
    private ApiCovid19 apiCovid19;

    public Covid19CountriesService(ApiCovid19 apiCovid19) {
        this.apiCovid19 = apiCovid19;
    }

    public List<Covid19> getDataOfApi() throws IOException, InterruptedException {

        List<Covid19> covid19 = (List<Covid19>) apiCovid19.getData();
        return covid19;
    }
}
