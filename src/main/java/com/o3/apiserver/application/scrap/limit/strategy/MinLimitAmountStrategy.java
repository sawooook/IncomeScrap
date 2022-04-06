package com.o3.apiserver.application.scrap.limit.strategy;

import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountType;
import com.o3.apiserver.common.util.TaxStandardUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MinLimitAmountStrategy implements LimitAmountStrategy {

    @Override
    public int process(int salaryAmount) {
        return TaxStandardUtil.limitAmountMinRefundStandard;
    }

    @Override
    public LimitAmountType type() {
        return LimitAmountType.MIN;
    }
}
