package com.o3.apiserver.application.scrap.limit.strategy.factory;

public enum LimitAmountType {
    CONDITION_A, CONDITION_B, CONDITION_C;

    public static LimitAmountType convertByAmount(int totalGiveAmount) {
        if (totalGiveAmount <= 33_000_000) {
            return CONDITION_A;
        } else if (totalGiveAmount <= 70_000_000) {
            return CONDITION_B;
        } else {
            return CONDITION_C;
        }
    }
}
