package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.port.ThirdPartyDrivenPort;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class GetScrapServiceTest {

    @Mock
    private ThirdPartyDrivenPort thirdPartyDrivenPort;

    @InjectMocks
    private GetScrapService getScrapService;

    @Test
    @DisplayName("스크랩을 가져올때 drivenPort가 한번 호출되어야한다 - O")
    void scrapSuccess() {
        LoginAuthUserDto autoDto =
                new LoginAuthUserDto(1L, "1", "123", "test", "860824-1655068");

        getScrapService.getScrap(autoDto);

        verify(thirdPartyDrivenPort, times(1)).getScrap(any());

    }
}