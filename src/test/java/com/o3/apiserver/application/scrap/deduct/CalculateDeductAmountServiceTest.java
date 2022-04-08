package com.o3.apiserver.application.scrap.deduct;

import com.o3.apiserver.application.scrap.deduct.strategy.ConditionADeductAmountStrategy;
import com.o3.apiserver.application.scrap.deduct.strategy.factory.DeductAmountFactory;
import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.o3.apiserver.util.CommonTestUtil.makeScrapTaxDetail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateDeductAmountServiceTest {


    @Mock
    private DeductAmountFactory deductAmountFactory;

    @Mock
    private ScrapTaxDetailDrivenPort scrapTaxDetailDrivenPort;

    @InjectMocks
    private CalculateDeductAmountService calculateDeductAmountService;

    @Test
    @DisplayName("130만원 이하이기 때문에 조건 A가 실행된다.")
    void successConditionA() {

        when(scrapTaxDetailDrivenPort.findByScrapId(any()))
                .thenReturn(makeScrapTaxDetail(1000));
        when(deductAmountFactory.get(any())).thenReturn(
                new ConditionADeductAmountStrategy()
        );

        int resultAmount = calculateDeductAmountService.getByScrapId(1L);

        assertEquals(resultAmount, 550);

        verify(scrapTaxDetailDrivenPort, times(1)).findByScrapId(any());
        verify(deductAmountFactory, times(1)).get(any());

    }

    @Test
    @DisplayName("130만원 이하이기 때문에 조건 B가 실행된다.")
    void successConditionB() {

        when(scrapTaxDetailDrivenPort.findByScrapId(any()))
                .thenReturn(makeScrapTaxDetail(1_430_000));
        when(deductAmountFactory.get(any())).thenReturn(
                new ConditionADeductAmountStrategy()
        );

        int resultAmount = calculateDeductAmountService.getByScrapId(1L);

        assertEquals(resultAmount, 786500);

        verify(scrapTaxDetailDrivenPort, times(1)).findByScrapId(any());
        verify(deductAmountFactory, times(1)).get(any());

    }
}