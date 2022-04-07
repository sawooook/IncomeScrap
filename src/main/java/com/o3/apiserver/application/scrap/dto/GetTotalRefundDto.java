package com.o3.apiserver.application.scrap.dto;

import com.o3.apiserver.common.util.TaxNameConvertUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetTotalRefundDto {

    private final String limitAmount;
    private final String deductAmount;
    private final String totalRefundAmount;
    private final String name;

    public static GetTotalRefundDto convert(int limitAmount, int deductAmount, int resultRefundAmount, String name) {
        return new GetTotalRefundDto(
                TaxNameConvertUtil.wonDisplay(limitAmount),
                TaxNameConvertUtil.wonDisplay(deductAmount),
                TaxNameConvertUtil.wonDisplay(resultRefundAmount),
                name
        );
    }
}