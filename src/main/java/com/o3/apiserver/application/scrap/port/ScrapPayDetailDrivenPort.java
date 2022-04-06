package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.domain.scrap.ScrapPayDetail;

public interface ScrapPayDetailDrivenPort {
    ScrapPayDetail save(ScrapPayDetail scrapPayDetail);
    ScrapPayDetail findByScrapId(Long id);
}
