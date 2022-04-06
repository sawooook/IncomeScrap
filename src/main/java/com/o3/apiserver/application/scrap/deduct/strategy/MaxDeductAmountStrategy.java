package com.o3.apiserver.application.scrap.deduct.strategy;

import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountType;
import com.o3.apiserver.common.util.TaxStandardUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.o3.apiserver.common.util.TaxStandardUtil.deductAmountMaxStandardNumber;

@Service
@Transactional
public class MaxDeductAmountStrategy implements DeductAmountStrategy {

    @Override
    public int process(int totalUseAmount) {
        int excessAmount = totalUseAmount - TaxStandardUtil.deductStandardAmount;
        double calcAmount = excessAmount * deductAmountMaxStandardNumber;

        return (int) (TaxStandardUtil.deductAdditionalAmount + calcAmount);
    }

    @Override
    public DeductAmountType type() {
        return DeductAmountType.MAX;
    }
}
