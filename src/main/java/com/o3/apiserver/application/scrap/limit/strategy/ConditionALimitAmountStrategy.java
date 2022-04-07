package com.o3.apiserver.application.scrap.limit.strategy;

import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountType;
import com.o3.apiserver.common.util.TaxConstantUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConditionALimitAmountStrategy implements LimitAmountStrategy {

    /**
     * 7000만원 초과 상품의 경우
     * */

    @Override
    public int process(int salaryAmount) {
        return TaxConstantUtil.근로소득_소액공제_최소공제금액;
    }

    @Override
    public LimitAmountType type() {
        return LimitAmountType.CONDITION_A;
    }
}
