package com.o3.apiserver.common.util;

public class TaxStandardUtil {

    // 근로소득 소액공제 최소 급여액 기준값
    public static int limitAmountMinSalaryStandard = 33_000_000;

    // 근로소득 소액공제 최대 기준값
    public static int limitAmountMaxSalaryStandard = 70_000_000;

    // 근로소득 소액 공제 최소 환급금액
    public static int limitAmountMinRefundStandard = 740_000;

    // 근로소득 소액 공제 최소 환급금액
    public static int limitAmountMaxRefundStandard = 660_000;

    // 근로소득 소액공제 계산을 위한 숫자값 (최소)
    public static double limitAmountMinStandardNumber = 0.008;

    // 근로소득 소액공제 계산을 위한 숫자값 (최댸)
    public static double limitAmountMaxStandardNumber = 0.5;

    // 근로소득 세액공제 계산식 (최소)
    public static double deductAmountMinStandardNumber = 0.55;

    // 근로소득 세액공제 계산식 (최대)
    public static double deductAmountMaxStandardNumber = 0.3;

    // 소액공제 공제액 기준값
    public static int deductStandardAmount = 1_300_000;

    // 추가 공제액 금액
    public static int deductAdditionalAmount = 715_000;
}
