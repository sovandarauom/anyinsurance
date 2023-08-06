package com.newbie.anyinsurance.services.products.BBB;

import com.newbie.anyinsurance.services.bases.DeathBenefitCalculator;
import org.springframework.stereotype.Component;

@Component
public class BBBDeathBenefitCalculator implements DeathBenefitCalculator {
    @Override
    public Double calculateDeathBenefit() {
        return 0.0;
    }
}
