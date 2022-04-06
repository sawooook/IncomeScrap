package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.domain.scrap.Scrap;

import java.util.List;

public interface ScrapDrivenPort {
    Scrap save(Scrap makeScrap);
    List<Scrap> getByUserUniqueId(String userUniqueId);
}
