package com.example.demo.controller;

import com.example.controller.MyController;
import com.example.models.TotalDuration;
import com.example.service.IntegrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MyControllerTest {
    @Mock
    private IntegrationService integrationService;

    private MyController myController;

    @BeforeEach
    public void setUp(){
        initMocks(this);
        myController = new MyController(integrationService);
    }

    @Test
    public void testGetTotalDurationInDateWithNoContent() throws ParseException {
        String date = "2020-06";
        when(integrationService.getTotalDurationInDate(date)).thenReturn(Collections.emptyList());

        ResponseEntity<List<TotalDuration>> responseEntity = myController.getTotalDurationInDate(date);
        assertEquals(HttpStatus.NO_CONTENT,responseEntity.getStatusCode());
    }

    @Test
    public void testGetTotalDurationInDateWithContent() throws ParseException {
        String date = "2020-06";
        TotalDuration totalDuration = TotalDuration.builder()
                .name("test")
                .lastname("test")
                .totalDuration(50)
                .build();

        List<TotalDuration> list = new ArrayList<>();
        list.add(totalDuration);

        when(integrationService.getTotalDurationInDate(date)).thenReturn(list);

        ResponseEntity<List<TotalDuration>> responseEntity = myController.getTotalDurationInDate(date);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(list.size(),responseEntity.getBody().size());
    }

}
