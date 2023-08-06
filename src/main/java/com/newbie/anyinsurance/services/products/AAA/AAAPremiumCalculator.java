package com.newbie.anyinsurance.services.products.AAA;

import com.newbie.anyinsurance.services.bases.PremiumCalculator;
import org.springframework.stereotype.Component;

@Component
public class AAAPremiumCalculator implements PremiumCalculator {

    @Override
    public Double calculatePremium(Double faceAmount, Double annualRate, Double paymentRate) {
        return faceAmount * annualRate * paymentRate;
    }

}
