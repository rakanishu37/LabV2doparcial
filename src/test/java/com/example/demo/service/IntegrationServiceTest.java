package com.example.demo.service;

import com.example.models.TotalDuration;
import com.example.service.IntegrationService;
import com.example.service.integration.IntegrationComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IntegrationServiceTest {
    @Mock
    private IntegrationComponent integrationComponent;

    private IntegrationService integrationService;

    @BeforeEach
    public void setUp(){
        initMocks(this);
        integrationService = new IntegrationService(integrationComponent);
    }

    @Test
    public void testGetTotalDurationInDate() throws ParseException {
        String yearMonth = "2020-06";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
        Date date = sd.parse(yearMonth);
        String stringDate = sd.format(date);

        TotalDuration totalDuration = TotalDuration.builder()
                .name("test")
                .lastname("test")
                .totalDuration(50)
                .build();

        List<TotalDuration> list = new ArrayList<>();
        list.add(totalDuration);
        when(integrationComponent.getTotalDurationInDate(stringDate)).thenReturn(list);
        List<TotalDuration> test =  integrationService.getTotalDurationInDate(stringDate);

        assertEquals(list.size(),test.size());
    }
}
