package com.o3.apiserver.common.util;

import java.text.DecimalFormat;

public class TaxNameConvertUtil {

    public static String wonDisplay(int amount) {
        String decimalFormatConvert = new DecimalFormat("##,####,####").format(amount);
        String[] splitFormat = decimalFormatConvert.split(",");
        String[] wonUnitList = {"천", "백", "십", ""};
        // 앞자리 제작
        StringBuffer firstBuffer = new StringBuffer();

        if (splitFormat.length == 3) {
            firstBuffer.append(splitFormat[0]).append("억").append(" ").append(splitFormat[1]).append("만");
        } else if (splitFormat.length == 2) {
            firstBuffer.append(splitFormat[0]).append("만");
        }

        // 뒷자리 제작
        StringBuffer secondBuffer = new StringBuffer();

        // 작업할 숫자
        String targetNumber = splitFormat[splitFormat.length - 1];

        for (int i = 0; i < targetNumber.length(); i++) {
            if (targetNumber.charAt(i) != '0') {
                secondBuffer.append(" ").append(targetNumber.charAt(i)).append(wonUnitList[i]);
            }
        }

        secondBuffer.append("원");
        return firstBuffer + secondBuffer.toString();
    }
}
