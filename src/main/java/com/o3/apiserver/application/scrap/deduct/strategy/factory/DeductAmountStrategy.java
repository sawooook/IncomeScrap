package com.o3.apiserver.application.scrap.deduct.strategy.factory;

public interface DeductAmountStrategy {
    int process(int totalUseAmount);
    DeductAmountType type();
}
