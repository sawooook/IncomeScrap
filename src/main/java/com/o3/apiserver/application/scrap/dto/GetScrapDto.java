package com.o3.apiserver.application.scrap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class GetScrapDto {
    private final GetScrapResultDto resultResponse;
    private final String appVersion;
    private final String hostName;
    private final LocalDateTime workerRequestDateTime;
    private final LocalDateTime workerResponseDateTime;
}
