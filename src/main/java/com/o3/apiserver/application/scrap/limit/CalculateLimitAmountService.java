package com.o3.apiserver.application.scrap.limit;

import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountFactory;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountType;
import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculateLimitAmountService {

    private final LimitAmountFactory limitAmountFactory;
    private final ScrapPayDetailDrivenPort scrapPayDetailDrivenPort;

    public int getByScrapId(Long id) {
        ScrapPayDetail scrapPayDetail = scrapPayDetailDrivenPort.findByScrapId(id);

        System.out.println("scrapPayDetail.getScrapId() = " + scrapPayDetail.getTotalGiveAmount());


        LimitAmountType type =
                LimitAmountType.convertByAmount(scrapPayDetail.getTotalGiveAmount());

        System.out.println("type = " + type);


        return limitAmountFactory.get(type)
                .process(scrapPayDetail.getTotalGiveAmount());

    }
}
