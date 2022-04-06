package com.o3.apiserver.application.scrap.limit.strategy.factory;

public enum LimitAmountType {
    MIN, MIDDLE, MAX;

    public static LimitAmountType convertByAmount(int totalGiveAmount) {
        if (totalGiveAmount <= 33_000_000) {
            return MIN;
        } else if (totalGiveAmount <= 70_000_000) {
            return MIDDLE;
        } else {
            return MAX;
        }
    }
}
