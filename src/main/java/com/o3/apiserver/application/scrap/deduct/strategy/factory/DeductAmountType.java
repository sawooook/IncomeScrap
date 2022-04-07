package com.o3.apiserver.application.scrap.deduct.strategy.factory;

import static com.o3.apiserver.common.util.TaxConstantUtil.근로소득_세엑공제_기준금액;

public enum DeductAmountType {
    CONDITION_A, CONDITION_B;

    public static DeductAmountType convertByUseAmount(int totalUseAmount) {
        if (totalUseAmount <= 근로소득_세엑공제_기준금액) {
            return CONDITION_A;
        } else {
            return CONDITION_B;
        }
    }
}
