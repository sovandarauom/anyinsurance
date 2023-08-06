package com.newbie.anyinsurance.services;

import com.newbie.anyinsurance.dto.CalculationRequest;
import com.newbie.anyinsurance.dto.Coverage;
import com.newbie.anyinsurance.entities.AnnualRate;
import com.newbie.anyinsurance.entities.InsuranceProduct;
import com.newbie.anyinsurance.entities.PaymentRate;
import com.newbie.anyinsurance.enums.ProductEnum;
import com.newbie.anyinsurance.enums.Schedule;
import com.newbie.anyinsurance.repositories.ProductRepository;
import com.newbie.anyinsurance.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    private final Map<ProductEnum, InsuranceProductTemplate> products;

    private final RateRepository rateRepository;

    private final ProductRepository productRepository;

    private List<AnnualRate> rates;

    private List<InsuranceProduct> insuranceProducts;


    @Autowired
    public InsuranceService(Map<ProductEnum, InsuranceProductTemplate> products, RateRepository rateRepository, ProductRepository productRepository) {
        this.products = products;
        this.rateRepository = rateRepository;
        this.productRepository = productRepository;

        this.rates = List.of(
                new AnnualRate(1L, 1L, ProductEnum.AAA, 0.1),
                new AnnualRate(2L, 2L, ProductEnum.BBB, 0.1)
        );

        var aaaPaymentRate = List.of(
                new PaymentRate(1L, 1L, Schedule.ANNUAL, 1.0),
                new PaymentRate(2L, 1L, Schedule.SEMI, 0.55),
                new PaymentRate(3L, 1L, Schedule.QUARTERLY, 0.30),
                new PaymentRate(4L, 1L, Schedule.MONTHLY, 0.12)
        );

        var bbbPaymentRate = List.of(
                new PaymentRate(5L, 2L, Schedule.ANNUAL, 1.0),
                new PaymentRate(6L, 2L, Schedule.SEMI, 0.55),
                new PaymentRate(7L, 2L, Schedule.QUARTERLY, 0.30),
                new PaymentRate(8L, 2L, Schedule.MONTHLY, 0.12)
        );

        this.insuranceProducts = List.of(
                new InsuranceProduct(1L, ProductEnum.AAA, "A001", "Product AAA", aaaPaymentRate),
                new InsuranceProduct(1L, ProductEnum.BBB, "B001", "Product BBB", bbbPaymentRate)
        );

    }

    public Map<String, List<Coverage>> calculate(CalculationRequest request) {

        /*
         * TODO: fetch rate and product details
         */


        var schedulePayment = request.getTerm() * request.getSchedule().getTimes();
        var coverages = request.getCoverages();

        Map<String, List<Coverage>> results = new HashMap<>();

        for (int schedule = 1; schedule <= schedulePayment; schedule++) {
            var coveragesResult = coverages
                    .stream()
                    .map(coverage -> {
                        var product = products.get(coverage.getCode());
                        return product.execute(coverage, insuranceProducts, rates, request.getSchedule());
                    }).collect(Collectors.toList());

            results.put(String.valueOf(schedule), coveragesResult);
        }
        return results;
    }
}