package com.o3.apiserver.application.scrap.deduct.strategy;

import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountType;
import com.o3.apiserver.common.util.TaxStandardUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MinDeductAmountStrategy implements DeductAmountStrategy {

    @Override
    public int process(int totalUseAmount) {
        return (int) (totalUseAmount * TaxStandardUtil.deductAmountMinStandardNumber);
    }

    @Override
    public DeductAmountType type() {
        return DeductAmountType.MIN;
    }
}
