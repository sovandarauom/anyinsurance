package com.newbie.anyinsurance.services.products.BBB;

import com.newbie.anyinsurance.services.bases.PremiumCalculator;
import org.springframework.stereotype.Component;

@Component
public class BBBPremiumCalculator implements PremiumCalculator {
    @Override
    public Double calculatePremium(Double faceAmount, Double annualRate, Double paymentRate) {
        return faceAmount * annualRate * paymentRate;
    }
}
