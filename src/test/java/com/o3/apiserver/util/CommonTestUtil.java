package com.o3.apiserver.util;

import com.o3.apiserver.application.scrap.dto.GetScrapDto;
import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import com.o3.apiserver.application.scrap.dto.GetScrapResultDto;
import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import com.o3.apiserver.application.user.dto.LoginUserDto;
import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import com.o3.apiserver.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class CommonTestUtil {

    public static LoginAuthUserDto makeLoginAuthDto() {
        return new LoginAuthUserDto(1L, "1", "test1234", "홍길동", "gdsjkgljdsl");
    }

    public static LoginUserDto makeLoginUserDto() {
        return new LoginUserDto("1", "test1234");
    }

    public static SignUpUserDto makeSignUpDto() {
        return new SignUpUserDto("1", "test1234", "홍길동", "860824-1655068");
    }

    public static User makeUser() {
        return new User("1", "test1234", "홍길동", "hasfdshfjkdhskf");
    }

    public static String makeToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjIwMTU4NzA1LCJleHAiOjE2MjAyNDUxMDV9.wNkQTyqP_Zxd6nEuhnMg30P-eyHRaerYixS_GV4yqYY";

    public static String makeHashPassword = "$2a$10$PyL.9gRsMmDSMxoAhTnGz.od06XbrKJxYjupyslopK16a1QqxTnD6";

    public static GetScrapPayDetailDto makeGetScrapPayDetailDto() {
        return new GetScrapPayDetailDto("test", "10000", LocalDate.of(2021, 2, 10), "테스트", "테스트", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 10), "test", "test", "test");
    }

    public static GetScrapTaxDetailDto makeScrapTaxDetailDto() {
        return new GetScrapTaxDetailDto("1244", "test");
    }

    public static GetScrapResultDto makeGetScrapResultDto() {
        return new GetScrapResultDto(Collections.singletonList(makeScrapTaxDetailDto()), Collections.singletonList(makeGetScrapPayDetailDto()), "test", "test", "test", "123");
    }

    public static GetScrapDto makeGetScrapDto() {
        return new GetScrapDto(makeGetScrapResultDto(), "test", "test", LocalDateTime.of(2021, 1, 1, 1, 1, 1, 1), LocalDateTime.of(2021, 1, 1, 1, 1, 1, 1));
    }

    public static Scrap makeScrap() {
        return new Scrap(1L, "test", "test", "test", "test", "test", LocalDateTime.of(2021, 1, 1, 1, 1, 1, 1), LocalDateTime.of(2021, 1, 1, 1, 1, 1, 1), new User());
    }

    public static ScrapPayDetail makeScrapPayDetail(int giveAmount) {
        return new ScrapPayDetail(1L, "test", giveAmount, "test", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 10), "test");
    }

    public static ScrapTaxDetail makeScrapTaxDetail(int amount) {
        return new ScrapTaxDetail(1L, amount);
    }
}
