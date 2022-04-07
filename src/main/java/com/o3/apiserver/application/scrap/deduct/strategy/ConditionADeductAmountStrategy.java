package com.o3.apiserver.application.scrap.deduct.strategy;

import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountType;
import com.o3.apiserver.common.util.TaxConstantUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConditionADeductAmountStrategy implements DeductAmountStrategy {

    /**
     * 130만원 이상
     */

    @Override
    public int process(int totalUseAmount) {
        return (int) (totalUseAmount * TaxConstantUtil.근로소득_세액공제_최소퍼센트);
    }

    @Override
    public DeductAmountType type() {
        return DeductAmountType.CONDITION_A;
    }
}
