package com.o3.apiserver.application.scrap.limit.strategy.factory;

public interface LimitAmountStrategy {
    int process(int salaryAmount);
    LimitAmountType type();
}
