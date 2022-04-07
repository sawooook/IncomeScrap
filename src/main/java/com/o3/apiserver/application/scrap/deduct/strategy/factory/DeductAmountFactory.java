package com.o3.apiserver.application.scrap.deduct.strategy.factory;

import com.o3.apiserver.application.scrap.deduct.strategy.ConditionADeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.ConditionBDeductAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionALimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionBLimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionCLimitAmountStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeductAmountFactory {

    public DeductAmountStrategy get(DeductAmountType type) {
        switch (type) {
            case CONDITION_A:
                return new ConditionADeductAmountStrategy();
            case CONDITION_B:
                return new ConditionBDeductAmountStrategy();
        }

        return null;
    }
}
