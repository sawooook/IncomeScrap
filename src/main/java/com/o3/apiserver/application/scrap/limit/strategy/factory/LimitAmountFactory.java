package com.o3.apiserver.application.scrap.limit.strategy.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LimitAmountFactory {

    private final Map<LimitAmountType, LimitAmountStrategy> limitAmountStrategyMap = new HashMap<>();

    public LimitAmountStrategy get(LimitAmountType type) {
        LimitAmountStrategy limitAmountStrategy = limitAmountStrategyMap.get(type);
        if (limitAmountStrategy == null) {
            throw new IllegalArgumentException("지원하지 않는 타입입니다");
        }

        return limitAmountStrategy;
    }
}
