package com.o3.apiserver.infrastructure.scrap.repository;

import com.o3.apiserver.domain.scrap.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScrapJpaRepository extends JpaRepository<Scrap, Long> {
    List<Scrap> findAllByUser(String userUniqueID);
}
