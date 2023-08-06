package com.newbie.anyinsurance.entities;

import com.newbie.anyinsurance.enums.ProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnnualRate {
    private Long id;
    private Long productId;
    private ProductEnum code;
    private Double rate; // annual rate
}
