package com.o3.apiserver.application.scrap.deduct;

import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountFactory;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountType;
import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculateDeductAmountService {

    private final DeductAmountFactory deductAmountFactory;
    private final ScrapTaxDetailDrivenPort scrapTaxDetailDrivenPort;


    public int getByScrapId(Long id) {
        ScrapTaxDetail taxDetail = scrapTaxDetailDrivenPort.findByScrapId(id);

        DeductAmountType type = DeductAmountType.convertByUseAmount(taxDetail.getTotalUseAmount());

        return deductAmountFactory.get(type)
                .process(taxDetail.getTotalUseAmount());

    }
}
