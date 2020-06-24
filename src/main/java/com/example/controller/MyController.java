package com.example.controller;

import com.example.models.TotalDuration;
import com.example.service.IntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {
    private final IntegrationService integrationService;

    @GetMapping("")
    @ApiOperation(code=200, value="")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de tiempo de llamadas en un mes indicado"),
            @ApiResponse(code = 204, message = "No hay registro de llamadas realizadas en el mes indicado")})
    public ResponseEntity<List<TotalDuration>> getTotalDurationInDate(@RequestParam(name = "yearMonth") String date) throws ParseException {
        List<TotalDuration> list = integrationService.getTotalDurationInDate(date);
        return (list.size() > 0) ? ResponseEntity.ok(list) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
