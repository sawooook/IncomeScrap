package com.o3.apiserver.application.scrap.deduct.strategy.factory;

import com.o3.apiserver.common.util.TaxStandardUtil;

public enum DeductAmountType {
    MIN, MAX;

    public static DeductAmountType convertByUseAmount(int totalUseAmount) {
        if (totalUseAmount <= TaxStandardUtil.deductStandardAmount) {
            return MIN;
        } else {
            return MAX;
        }
    }
}
