package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.deduct.CalculateDeductAmountService;
import com.o3.apiserver.application.scrap.dto.GetTotalRefundDto;
import com.o3.apiserver.application.scrap.limit.CalculateLimitAmountService;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.common.util.TaxExpressionUtil;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculateRefundScrapService {

    private final CalculateDeductAmountService calculateDeductAmountService;
    private final CalculateLimitAmountService calculateLimitAmountService;
    private final UserDrivenPort userDrivenPort;


    public GetTotalRefundDto getByUserUniqueId(LoginAuthUserDto authDto) {
        User user = userDrivenPort.findByUserUniqueId(authDto.getUserUniqueId());
        List<Scrap> scrapList = user.getScrapList();
        Scrap targetScrap = scrapList.get(scrapList.size() - 1);

        // 한도금액 계산
        int limitAmount = calculateLimitAmountService.getByScrapId(targetScrap.getId());

        // 공제액 계산
        int deductAmount = calculateDeductAmountService.getByScrapId(targetScrap.getId());

        // 최종 환급액
        int resultRefundAmount = TaxExpressionUtil.getRefundAmount(limitAmount, deductAmount);

        return GetTotalRefundDto.convert(limitAmount, deductAmount, resultRefundAmount, authDto.getName());
    }
}
