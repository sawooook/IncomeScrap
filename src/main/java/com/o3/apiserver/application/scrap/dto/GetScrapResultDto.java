package com.o3.apiserver.application.scrap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GetScrapResultDto {
    private final List<GetScrapTaxDetailDto> taxDetailResponse;
    private final List<GetScrapPayDetailDto> payDetailResponse;
    private final String errorMessage;
    private final String company;
    private final String scvCd;
    private final String userUniqueId;
}
