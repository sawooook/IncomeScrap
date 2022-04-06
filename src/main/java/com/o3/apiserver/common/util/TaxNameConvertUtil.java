package com.o3.apiserver.common.util;

import java.text.DecimalFormat;

public class TaxNameConvertUtil {

    public static String wonDisplay(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("##,####,####");
        String decimalFormatConvert = decimalFormat.format(amount);
        String[] splitFormat = decimalFormatConvert.split(",");
        String[] wonUnitList = {"천", "백", "십", ""};


        StringBuffer stringBuffer = new StringBuffer();
        if (splitFormat.length == 3) {
            stringBuffer.append(splitFormat[0]).append("억").append(" ");
            stringBuffer.append(splitFormat[1]).append("만");
        } else if (splitFormat.length == 2) {
            stringBuffer.append(splitFormat[0]).append("만");
        }


        stringBuffer.setLength(0);

        String targetNumber = splitFormat[splitFormat.length - 1];


        for (int i = 0; i < targetNumber.length(); i++) {
            if (targetNumber.charAt(i) == '0') {
                continue;
            }

            stringBuffer.append(targetNumber.charAt(i));
            stringBuffer.append(wonUnitList[i]);
        }


        if (stringBuffer.length() == 0) {
            stringBuffer.append("원");
        } else {
            stringBuffer.append(" ").append("원");
        }

        return stringBuffer.toString();
    }
}
