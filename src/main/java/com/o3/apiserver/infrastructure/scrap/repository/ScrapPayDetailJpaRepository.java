package com.o3.apiserver.infrastructure.scrap.repository;

import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapPayDetailJpaRepository extends JpaRepository<ScrapPayDetail, Long> {
    ScrapPayDetail findByScrapId(long scarpId);
}
