package com.o3.apiserver.infrastructure.thirdparty.adapter.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetThirdPartyScrapDto {
    private final String name;
    private final String registerNumber;
}
