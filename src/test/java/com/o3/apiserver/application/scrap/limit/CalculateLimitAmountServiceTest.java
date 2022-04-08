package com.o3.apiserver.application.scrap.limit;

import com.o3.apiserver.application.scrap.limit.strategy.ConditionALimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionBLimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.ConditionCLimitAmountStrategy;
import com.o3.apiserver.application.scrap.limit.strategy.factory.LimitAmountFactory;
import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.o3.apiserver.common.util.TaxConstantUtil.근로소득_소액공제_최소공제금액;
import static com.o3.apiserver.util.CommonTestUtil.makeScrapPayDetail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateLimitAmountServiceTest {

    @Mock
    private LimitAmountFactory limitAmountFactory;

    @Mock
    private ScrapPayDetailDrivenPort scrapPayDetailDrivenPort;

    @InjectMocks
    private CalculateLimitAmountService calculateLimitAmountService;

    @Test
    @DisplayName("금액이 3300만원 이하이기 때문에 조건A 가 실행되어 값을 return 받는다 - O")
    void successConditionA() {

        when(scrapPayDetailDrivenPort.findByScrapId(any()))
                .thenReturn(makeScrapPayDetail(1000));
        when(limitAmountFactory.get(any())).thenReturn(
                new ConditionALimitAmountStrategy()
        );

        int resultAmount = calculateLimitAmountService.getByScrapId(1L);

        assertEquals(resultAmount, 근로소득_소액공제_최소공제금액);

        verify(scrapPayDetailDrivenPort, times(1)).findByScrapId(any());
        verify(limitAmountFactory, times(1)).get(any());
    }

    @Test
    @DisplayName("금액이 3300초과 7000만원 이하이기 때문에 조건B 가 실행되어 값을 return 받는다 - O")
    void successConditionB() {

        when(scrapPayDetailDrivenPort.findByScrapId(any()))
                .thenReturn(makeScrapPayDetail(35_000_000));
        when(limitAmountFactory.get(any())).thenReturn(
                new ConditionBLimitAmountStrategy()
        );

        int resultAmount = calculateLimitAmountService.getByScrapId(1L);

        assertEquals(resultAmount, 724000);

        verify(scrapPayDetailDrivenPort, times(1)).findByScrapId(any());
        verify(limitAmountFactory, times(1)).get(any());
    }

    @Test
    @DisplayName("금액이 7000만원 초과이기 때문에 조건C 가 실행되어 값을 return 받는다 - O")
    void successConditionC() {

        when(scrapPayDetailDrivenPort.findByScrapId(any()))
                .thenReturn(makeScrapPayDetail(71_000_000));
        when(limitAmountFactory.get(any())).thenReturn(
                new ConditionCLimitAmountStrategy()
        );

        int resultAmount = calculateLimitAmountService.getByScrapId(1L);

        assertEquals(resultAmount, 660000);

        verify(scrapPayDetailDrivenPort, times(1)).findByScrapId(any());
        verify(limitAmountFactory, times(1)).get(any());
    }
}