package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.port.ScrapDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.o3.apiserver.util.CommonTestUtil.makeGetScrapDto;
import static com.o3.apiserver.util.CommonTestUtil.makeScrap;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MakeScrapServiceTest {

    @Mock
    private ScrapDrivenPort scrapDrivenPort;
    @Mock
    private UserDrivenPort userDrivenPort;
    @Mock
    private ScrapTaxDetailDrivenPort scrapTaxDetailDrivenPort;
    @Mock
    private ScrapPayDetailDrivenPort scrapPayDetailDrivenPort;

    @InjectMocks
    private MakeScrapService makeScrapService;

    @Test
    @DisplayName("성공적으로 스크랩한 데이터를 저장한다 - O")
    void successScrap() {


        when(scrapDrivenPort.save(any()))
                .thenReturn(makeScrap());

        makeScrapService.make(makeGetScrapDto());

        verify(userDrivenPort, times(1)).findByUserUniqueId(any());
        verify(scrapDrivenPort, times(1)).save(any());
        verify(scrapTaxDetailDrivenPort, times(1)).save(any());
        verify(scrapPayDetailDrivenPort, times(1)).save(any());
    }
}




























