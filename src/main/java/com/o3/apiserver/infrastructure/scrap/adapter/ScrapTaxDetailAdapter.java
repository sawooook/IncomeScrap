package com.o3.apiserver.infrastructure.scrap.adapter;

import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import com.o3.apiserver.common.exception.NotFoundDataException;
import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import com.o3.apiserver.infrastructure.scrap.repository.ScrapTaxDetailJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapTaxDetailAdapter implements ScrapTaxDetailDrivenPort {

    private final ScrapTaxDetailJpaRepository scrapTaxDetailJpaRepository;

    @Override
    public ScrapTaxDetail save(ScrapTaxDetail scrapTaxDetail) {
        return scrapTaxDetailJpaRepository.save(scrapTaxDetail);
    }

    @Override
    public ScrapTaxDetail findByScrapId(Long id) {
        return scrapTaxDetailJpaRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundDataException();
        });
    }
}
