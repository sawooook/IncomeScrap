package com.o3.apiserver.application.scrap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetScrapTaxDetailDto {
    private final String totalUseAmount;
    private final String incomePayType;
}
