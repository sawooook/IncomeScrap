package com.o3.apiserver.common.util;

import java.time.LocalDate;

public class TimeConvertUtil {

    public static LocalDate toLocalDate(String date) {
        return LocalDate.parse(date.replaceAll("\\.", "-"));
    }
}
