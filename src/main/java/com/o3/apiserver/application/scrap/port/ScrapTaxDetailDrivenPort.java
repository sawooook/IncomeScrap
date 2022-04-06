package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.domain.scrap.ScrapTaxDetail;

public interface ScrapTaxDetailDrivenPort {
    ScrapTaxDetail save(ScrapTaxDetail scrapTaxDetail);

    ScrapTaxDetail findByScrapId(Long id);
}
