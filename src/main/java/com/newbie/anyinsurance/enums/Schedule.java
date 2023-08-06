package com.newbie.anyinsurance.enums;

public enum Schedule {
    MONTHLY(12),
    QUARTERLY(4),
    SEMI(2),
    ANNUAL(1);

    private Integer times;

    Schedule(Integer times) {
        this.times = times;
    }

    public Integer getTimes() {
        return times;
    }
}
