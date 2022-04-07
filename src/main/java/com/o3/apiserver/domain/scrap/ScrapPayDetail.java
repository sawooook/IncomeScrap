package com.o3.apiserver.domain.scrap;

import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "scrap")
@NoArgsConstructor
@Getter
public class ScrapPayDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId = null;

    @Column(name = "type")
    private String type;

    @Column(name = "total_give_amount")
    private int totalGiveAmount; // 총지급액

    @Column(name = "company_name")
    private String companyName; // 지급회사이름

    @Column(name = "give_amount_at")
    private LocalDate giveAmountAt; // 지급일

    @Column(name = "work_ended_at")
    private LocalDate workEndedAt; // 업무 종료일

    @Column(name = "work_started_at")
    private LocalDate workStartedAt; // 업무 시작 날짜

    @Column(name = "company_register_number")
    private String companyRegisterNumber; // 사업자 등록 번호

    public ScrapPayDetail(long scrapId, String type, int totalGiveAmount, String companyName, LocalDate giveAmountAt, LocalDate workEndedAt, LocalDate workStartedAt, String companyRegisterNumber) {
        this.scrapId = scrapId;
        this.type = type;
        this.totalGiveAmount = totalGiveAmount;
        this.companyName = companyName;
        this.giveAmountAt = giveAmountAt;
        this.workEndedAt = workEndedAt;
        this.workStartedAt = workStartedAt;
        this.companyRegisterNumber = companyRegisterNumber;
    }

    public static ScrapPayDetail create(Scrap scrap, GetScrapPayDetailDto payDetail) {
        return new ScrapPayDetail(
                scrap.getId(), payDetail.getIncomeHistoryType(), Integer.parseInt(payDetail.getTotalGiveAmount()),
                payDetail.getCompanyName(), payDetail.getGiveAmountAt(),
                payDetail.getWordEndAt(), payDetail.getWorkStartedAt(), payDetail.getCompanyRegisterNumber()
        );
    }
}

