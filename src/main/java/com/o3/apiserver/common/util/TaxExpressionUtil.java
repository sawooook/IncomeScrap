package com.o3.apiserver.common.util;

public class TaxExpressionUtil {

    // 근로소득 세액공제 한도 계산식
    public static double getLimitAmount(int standardRefundAmount, int salaryAmount, int standardSalaryAmount, double standardPercent) {
        return (standardRefundAmount - (salaryAmount - standardSalaryAmount) * standardPercent);
    }


    // 환급액 계산식
    public static int getRefundAmount(int limitAmount, int deductAmount) {
        return Math.min(limitAmount, deductAmount);
    }
}
