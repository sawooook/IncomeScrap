package com.o3.apiserver.application.scrap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class GetScrapPayDetailDto {
    private final String incomeHistoryType;
    private final String totalGiveAmount;
    private final LocalDate workStartedAt;
    private final String companyName;
    private final String name;
    private final LocalDate giveAmountAt;
    private final LocalDate wordEndAt;
    private final String registerNumber;
    private final String incomePayType;
    private final String companyRegisterNumber;
}

