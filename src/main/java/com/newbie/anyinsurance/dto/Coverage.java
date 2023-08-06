package com.newbie.anyinsurance.dto;

import com.newbie.anyinsurance.enums.ProductEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Coverage {
    private ProductEnum code;
    private String planCode;
    private Double faceAmount;
    private Double premium;
    private Double deathBenefit;
    private Double maturityBenefit;
}
