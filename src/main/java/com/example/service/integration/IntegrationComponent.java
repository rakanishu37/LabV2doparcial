package com.example.service.integration;

import com.example.models.TotalDuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class IntegrationComponent {
    private RestTemplate rest;
    private final static String URL = "http://localhost:8080/";
    private final static String URL_CALLS = URL + "calls";
    private final static String URL_TOTAL_DURATION = URL_CALLS + "?yearMonth=";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }

    public List<TotalDuration> getTotalDurationInDate(String stringDate){
        TotalDuration[] list = rest.getForObject(URL_TOTAL_DURATION + stringDate, TotalDuration[].class);
        return Arrays.asList(list);
    }
}
