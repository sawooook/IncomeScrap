package com.o3.apiserver.application.scrap.limit.strategy.factory;

import com.o3.apiserver.application.scrap.limit.strategy.ConditionALimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionBLimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionCLimitAmountStrategy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class LimitAmountFactory {

    public LimitAmountStrategy get(LimitAmountType type) {
        switch (type) {
            case CONDITION_A:
                return new ConditionALimitAmountStrategy();
            case CONDITION_B:
                return new ConditionBLimitAmountStrategy();
            case CONDITION_C:
                return new ConditionCLimitAmountStrategy();
        }

        return null;
    }
}
