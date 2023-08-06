package com.newbie.anyinsurance.dto;

import com.newbie.anyinsurance.enums.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CalculationRequest {
    private Schedule schedule; // MONTHLY
    private Integer term; // 10y
    private List<Coverage> coverages;
}
