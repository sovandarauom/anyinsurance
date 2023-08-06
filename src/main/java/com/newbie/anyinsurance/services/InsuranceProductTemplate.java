package com.newbie.anyinsurance.services;

import com.newbie.anyinsurance.dto.Coverage;
import com.newbie.anyinsurance.entities.AnnualRate;
import com.newbie.anyinsurance.entities.InsuranceProduct;
import com.newbie.anyinsurance.enums.Schedule;
import com.newbie.anyinsurance.services.bases.DeathBenefitCalculator;
import com.newbie.anyinsurance.services.bases.MaturityBenefitCalculator;
import com.newbie.anyinsurance.services.bases.PremiumCalculator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class InsuranceProductTemplate {

    private final PremiumCalculator premiumCalculator;
    private final DeathBenefitCalculator deathBenefitCalculator;
    private final MaturityBenefitCalculator maturityBenefitCalculator;

    public InsuranceProductTemplate(PremiumCalculator premiumCalculator, DeathBenefitCalculator deathBenefitCalculator, MaturityBenefitCalculator maturityBenefitCalculator) {
        this.premiumCalculator = premiumCalculator;
        this.deathBenefitCalculator = deathBenefitCalculator;
        this.maturityBenefitCalculator = maturityBenefitCalculator;
    }

    public double calculatePremium(Double faceAmount, Double annualRate, Double paymentRate) {
        if (premiumCalculator != null) {
            return premiumCalculator.calculatePremium(faceAmount, annualRate, paymentRate);
        } else {
            // Handle the case when premium calculation is not available for this product
            return 0.0;
        }
    }

    public double calculateDeathBenefit() {
        if (deathBenefitCalculator != null) {
            return deathBenefitCalculator.calculateDeathBenefit();
        } else {
            // Handle the case when death benefit calculation is not available for this product
            return 0.0;
        }
    }

    public double calculateMaturityBenefit() {
        if (maturityBenefitCalculator != null) {
            return maturityBenefitCalculator.calculateMaturityBenefit();
        } else {
            // Handle the case when maturity benefit calculation is not available for this product
            return 0.0;
        }
    }

    public Coverage execute(Coverage coverage, List<InsuranceProduct> products, List<AnnualRate> rates, Schedule schedule) {

        var productCode = coverage.getCode();

        var optionalAnnualRate = rates.stream()
                .filter(r -> r.getCode().equals(productCode))
                .findFirst();

        if (optionalAnnualRate.isEmpty()) {
            throw new RuntimeException("invalid product code");
        }

        var optionalInsuranceProduct = products.stream()
                .filter(p -> p.getCode().equals(productCode))
                .findFirst();

        if (optionalInsuranceProduct.isEmpty()) {
            throw new RuntimeException("invalid product code");
        }

        var paymentRate = optionalInsuranceProduct.get().getPaymentRate()
                .stream()
                .filter(f -> f.getSchedule().equals(schedule))
                .findFirst();


        var premium = this.calculatePremium(coverage.getFaceAmount(), optionalAnnualRate.get().getRate(), paymentRate.get().getRate());
        var deathBenefit = this.calculateDeathBenefit();
        var maturityBenefit = this.calculateMaturityBenefit();

        coverage.setPremium(premium);
        coverage.setDeathBenefit(deathBenefit);
        coverage.setMaturityBenefit(maturityBenefit);

        return coverage;
    }
}
