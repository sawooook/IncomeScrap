package com.o3.apiserver.infrastructure.scrap.adapter;

import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import com.o3.apiserver.common.exception.NotFoundDataException;
import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import com.o3.apiserver.infrastructure.scrap.repository.ScrapPayDetailJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapPayDetailAdapter implements ScrapPayDetailDrivenPort {

    private final ScrapPayDetailJpaRepository scrapPayDetailJpaRepository;

    @Override
    public ScrapPayDetail save(ScrapPayDetail scrapPayDetail) {
        return scrapPayDetailJpaRepository.save(scrapPayDetail);
    }

    @Override
    public ScrapPayDetail findByScrapId(Long id) {
        return scrapPayDetailJpaRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundDataException();
        });
    }
}
