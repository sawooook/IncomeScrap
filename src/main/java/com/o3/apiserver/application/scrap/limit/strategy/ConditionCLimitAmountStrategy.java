package com.o3.apiserver.application.scrap.limit.strategy;

import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountType;
import com.o3.apiserver.common.util.TaxExpressionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.o3.apiserver.common.util.TaxConstantUtil.*;

@Service
@Transactional
public class ConditionCLimitAmountStrategy implements LimitAmountStrategy {

    /**
    * 3,300만원 이하 상품의 경우
    * */

    @Override
    public int process(int salaryAmount) {
        int result = (int) TaxExpressionUtil.getLimitAmount(
                근로소득_소액공제_최대공제금액, salaryAmount, 근로소득_소액공제_최대기준금액, 근로소득_소액공제_최대퍼센트
        );

        return Math.max(result, 근로소득_소액공제_최대공제금액);
    }

    @Override
    public LimitAmountType type() {
        return LimitAmountType.CONDITION_C;
    }
}
