package com.o3.apiserver.infrastructure.scrap.adapter;

import com.o3.apiserver.application.scrap.port.ScrapDrivenPort;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.infrastructure.scrap.repository.ScrapJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapAdapter implements ScrapDrivenPort {

    private final ScrapJpaRepository scrapJpaRepository;

    @Override
    public Scrap save(Scrap makeScrap) {
        return scrapJpaRepository.save(makeScrap);
    }

    @Override
    public List<Scrap> getByUserUniqueId(String userUniqueId) {
        return scrapJpaRepository.findAllByUserUniqueId(userUniqueId);
    }
}
