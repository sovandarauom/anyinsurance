package com.newbie.anyinsurance.services.bases;

import com.newbie.anyinsurance.services.bases.InsuranceCalculator;

public interface PremiumCalculator extends InsuranceCalculator {
    Double calculatePremium(Double faceAmount, Double annualRate, Double paymentRate);
}
