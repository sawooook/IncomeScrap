package com.o3.apiserver.application.scrap.deduct.strategy.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeductAmountFactory {

    private final Map<DeductAmountType, DeductAmountStrategy> deductAmountStrategyMap = new HashMap<>();

    public DeductAmountStrategy get(DeductAmountType type) {
        DeductAmountStrategy deductAmountStrategy = deductAmountStrategyMap.get(type);
        if (deductAmountStrategy == null) {
            throw new IllegalArgumentException("지원하지 않는 타입입니다");
        }

        return deductAmountStrategy;
    }
}
