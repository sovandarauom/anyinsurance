package com.newbie.anyinsurance.entities;

import com.newbie.anyinsurance.enums.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRate {
    private Long id;
    private Long productId;
    private Schedule schedule;
    private Double rate;
}
