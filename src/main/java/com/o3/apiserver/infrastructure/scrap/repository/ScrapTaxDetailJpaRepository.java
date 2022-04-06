package com.o3.apiserver.infrastructure.scrap.repository;

import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapTaxDetailJpaRepository extends JpaRepository<ScrapTaxDetail, Long> {
}
