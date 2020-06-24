package com.example.service;

import com.example.models.TotalDuration;
import com.example.service.integration.IntegrationComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IntegrationService {
    private final IntegrationComponent integrationComponent;

    public List<TotalDuration> getTotalDurationInDate(String yearMonth) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
        Date date = sd.parse(yearMonth);
        String stringDate = sd.format(date);
        return integrationComponent.getTotalDurationInDate(stringDate);
    }
}
