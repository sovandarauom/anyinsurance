package com.newbie.anyinsurance.entities;

import com.newbie.anyinsurance.enums.ProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InsuranceProduct {
    private Long id;
    private ProductEnum code;
    private String planCode;
    private String productName;
    private List<PaymentRate> paymentRate;

}
