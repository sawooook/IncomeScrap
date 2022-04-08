package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.deduct.CalculateDeductAmountService;
import com.o3.apiserver.application.scrap.limit.CalculateLimitAmountService;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.exception.NotFoundScrapDataException;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.domain.user.User;
import com.o3.apiserver.util.CommonTestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRefundScrapServiceTest {

    @Mock
    private CalculateDeductAmountService calculateDeductAmountService;
    @Mock
    private CalculateLimitAmountService calculateLimitAmountService;
    @Mock
    private UserDrivenPort userDrivenPort;

    @InjectMocks
    private CalculateRefundScrapService calculateRefundScrapService;


    @Test
    @DisplayName("성공적으로 환급금액을 구한다 - O")
    void successRefund() {
        when(userDrivenPort.findByUserUniqueId(any()))
                .thenReturn(new User(1L, "test", "test", "test", "test", Arrays.asList(new Scrap())));

        calculateRefundScrapService.getByUserUniqueId(CommonTestUtil.makeLoginAuthDto());

        verify(userDrivenPort, times(1)).findByUserUniqueId(any());
        verify(calculateLimitAmountService, times(1)).getByScrapId(any());
        verify(calculateDeductAmountService, times(1)).getByScrapId(any());
    }

    @Test
    @DisplayName("스크랩 리스트가 존재하지 않으면 오류를 return 한다 - X")
    void successFailNotScrap() {
        when(userDrivenPort.findByUserUniqueId(any()))
                .thenReturn(new User(1L, "test", "test", "test", "test", Collections.emptyList()));

        assertThrows(NotFoundScrapDataException.class, () -> {
            calculateRefundScrapService.getByUserUniqueId(CommonTestUtil.makeLoginAuthDto());
        });


        verify(userDrivenPort, times(1)).findByUserUniqueId(any());
        verify(calculateLimitAmountService, times(0)).getByScrapId(any());
        verify(calculateDeductAmountService, times(0)).getByScrapId(any());
    }


}