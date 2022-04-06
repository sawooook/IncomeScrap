package com.o3.apiserver.application.scrap.limit.strategy;

import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountType;
import com.o3.apiserver.common.util.TaxExpressionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.o3.apiserver.common.util.TaxStandardUtil.*;

@Service
@Transactional
public class MiddleLimitAmountStrategy implements LimitAmountStrategy {

    @Override
    public int process(int salaryAmount) {
        int result = (int) TaxExpressionUtil.getLimitAmount(
                limitAmountMinRefundStandard, salaryAmount, limitAmountMinSalaryStandard, limitAmountMinStandardNumber
        );

        return Math.max(result, limitAmountMaxRefundStandard);
    }

    @Override
    public LimitAmountType type() {
        return LimitAmountType.MIDDLE;
    }
}
