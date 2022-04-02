package com.o3.apiserver.domain.scrap;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "scrap")
@NoArgsConstructor
public class ScrapPayDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrap_id;

    @Column(name = "type")
    private String type;

    @Column(name = "total_give_amount")
    private int totalGiveAmount;

    @Column(name = "company_name")
    private LocalDate companyName; // 지급회사이름

    @Column(name = "give_amount_at")
    private LocalDate giveAmountAt; // 총 지급액

    @Column(name = "work_ended_at")
    private LocalDate workEndedAt; // 업무 종료일

    @Column(name = "work_started_at")
    private LocalDate work_started_at; // 업무 시작 날짜

    @Column(name = "company_register_number")
    private String companyRegisterNumber; // 사업자 등록 번호
}
