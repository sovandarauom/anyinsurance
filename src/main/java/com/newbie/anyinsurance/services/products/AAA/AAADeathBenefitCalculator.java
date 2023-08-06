package com.newbie.anyinsurance.services.products.AAA;

import com.newbie.anyinsurance.services.bases.DeathBenefitCalculator;
import org.springframework.stereotype.Component;

@Component
public class AAADeathBenefitCalculator implements DeathBenefitCalculator {

    @Override
    public Double calculateDeathBenefit() {
        return 0.0;
    }
}
