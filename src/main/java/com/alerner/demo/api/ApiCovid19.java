package com.alerner.demo.api;

import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class ApiCovid19
{
    @CircuitBreaker(name = "apiCovid19", fallbackMethod = "fallbackApi")
    public Covid19 getData() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://covid-193.p.rapidapi.com/countries"))
                .header("accept","application/json")
                .header("x-rapidapi-key","5a84f3dc9fmsh3a4601899349ac6p16c605jsn13b802944a71")
                .header("x-rapidapi-host","covid-193.p.rapidapi.com")
                .method("GET",HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String>responseApi = HttpClient.newHttpClient().send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(responseApi.body(), (Type) Covid19.class);
    }

    public Covid19 fallbackApi(final Throwable throwable)
    {
        log.info("Error, {}",throwable.toString());
        return null;
    }

}
