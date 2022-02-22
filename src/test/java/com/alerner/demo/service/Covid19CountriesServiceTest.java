package com.alerner.demo.service;

import com.alerner.demo.api.ApiCovid19;
import com.alerner.demo.api.Covid19;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = Covid19CountriesService.class)
public class Covid19CountriesServiceTest
{
    @InjectMocks
    private Covid19CountriesService covid19CountriesService;

    @Mock
    ApiCovid19 apiCovid19;

    @BeforeEach
    public void setUp()
    {
        apiCovid19 = mock(ApiCovid19.class);
        covid19CountriesService = mock(Covid19CountriesService.class);
    }


    @SneakyThrows
    @Test
    void getDataOfApiTest()
    {
        when(apiCovid19.getData()).thenReturn(apiCovid19.getData());
        List<Covid19>covid19List = covid19CountriesService.getDataOfApi();

    }
}
