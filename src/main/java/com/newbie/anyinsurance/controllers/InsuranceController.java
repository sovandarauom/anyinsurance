package com.newbie.anyinsurance.controllers;

import com.newbie.anyinsurance.dto.CalculationRequest;
import com.newbie.anyinsurance.dto.Coverage;
import com.newbie.anyinsurance.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/calculateBenefits")
    public Mono<Map<String, List<Coverage>>> calculate(@RequestBody CalculationRequest request) {
        Map<String, List<Coverage>> results = insuranceService.calculate(request);
        return Mono.just(results);
    }
}