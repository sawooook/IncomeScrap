package com.o3.apiserver.application.scrap.deduct.strategy;

import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.o3.apiserver.common.util.TaxConstantUtil.*;

@Service
@Transactional
public class ConditionBDeductAmountStrategy implements DeductAmountStrategy {

    /**
     * 130만원 이하
     */

    @Override
    public int process(int totalUseAmount) {
        int excessAmount = totalUseAmount - 근로소득_세엑공제_기준금액;
        double calcAmount = excessAmount * 근로소득_세액공제_최대퍼센트;

        return (int) (근로소득_세액공제_최대공제금액 + calcAmount);
    }

    @Override
    public DeductAmountType type() {
        return DeductAmountType.CONDITION_B;
    }
}
