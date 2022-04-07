package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.domain.scrap.Scrap;

public interface ScrapDrivenPort {
    Scrap save(Scrap makeScrap);
}
