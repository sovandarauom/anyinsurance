package com.newbie.anyinsurance.services.products.BBB;

import com.newbie.anyinsurance.services.bases.MaturityBenefitCalculator;
import org.springframework.stereotype.Component;

@Component
public class BBBMaturityBenefitCalculator implements MaturityBenefitCalculator {
    @Override
    public Double calculateMaturityBenefit() {
        return 0.0;
    }
}
