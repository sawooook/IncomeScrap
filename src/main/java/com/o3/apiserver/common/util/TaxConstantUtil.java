package com.o3.apiserver.common.util;

public class TaxConstantUtil {

    // 소액공제

    public static int 근로소득_소액공제_최소기준금액 = 33_000_000;

    public static int 근로소득_소액공제_최대기준금액 = 70_000_000;

    public static int 근로소득_소액공제_최소공제금액 = 740_000;

    public static int 근로소득_소액공제_최대공제금액 = 660_000;

    public static double 근로소득_소액공제_최소퍼센트 = 0.008;

    public static double 근로소득_소액공제_최대퍼센트 = 0.5;

    // 세액공제

    public static double 근로소득_세액공제_최소퍼센트 = 0.55;

    public static double 근로소득_세액공제_최대퍼센트 = 0.3;

    public static int 근로소득_세엑공제_기준금액 = 1_300_000;

    public static int 근로소득_세액공제_최대공제금액 = 715_000;
}
