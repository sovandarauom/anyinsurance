package com.newbie.anyinsurance.services;

import com.newbie.anyinsurance.enums.ProductEnum;
import com.newbie.anyinsurance.services.products.AAA.AAADeathBenefitCalculator;
import com.newbie.anyinsurance.services.products.AAA.AAAPremiumCalculator;
import com.newbie.anyinsurance.services.products.BBB.BBBDeathBenefitCalculator;
import com.newbie.anyinsurance.services.products.BBB.BBBMaturityBenefitCalculator;
import com.newbie.anyinsurance.services.products.BBB.BBBPremiumCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductFactoryBean {

    private final AAAPremiumCalculator aaaPremiumCalculator;

    private final AAADeathBenefitCalculator aaaDeathBenefitCalculator;

    private final BBBPremiumCalculator bbbPremiumCalculator;

    private final BBBDeathBenefitCalculator bbbDeathBenefitCalculator;

    private final BBBMaturityBenefitCalculator bbbMaturityBenefitCalculator;

    public ProductFactoryBean(
            AAAPremiumCalculator aaaPremiumCalculator,
            AAADeathBenefitCalculator aaaDeathBenefitCalculator,
            BBBPremiumCalculator bbbPremiumCalculator,
            BBBDeathBenefitCalculator bbbDeathBenefitCalculator,
            BBBMaturityBenefitCalculator bbbMaturityBenefitCalculator) {
        this.aaaPremiumCalculator = aaaPremiumCalculator;
        this.aaaDeathBenefitCalculator = aaaDeathBenefitCalculator;
        this.bbbPremiumCalculator = bbbPremiumCalculator;
        this.bbbDeathBenefitCalculator = bbbDeathBenefitCalculator;
        this.bbbMaturityBenefitCalculator = bbbMaturityBenefitCalculator;
    }


    @Bean
    public Map<ProductEnum, InsuranceProductTemplate> products() {
        Map<ProductEnum, InsuranceProductTemplate> products = new HashMap<>();
        products.put(ProductEnum.AAA, new InsuranceProductTemplate(aaaPremiumCalculator, aaaDeathBenefitCalculator, null));
        products.put(ProductEnum.BBB, new InsuranceProductTemplate(bbbPremiumCalculator, bbbDeathBenefitCalculator, bbbMaturityBenefitCalculator));
        // add your product code and class
        return products;
    }
}