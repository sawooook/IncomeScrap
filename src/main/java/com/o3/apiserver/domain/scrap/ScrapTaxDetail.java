package com.o3.apiserver.domain.scrap;


import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "scrap_tax_detail")
@NoArgsConstructor
@Getter
public class ScrapTaxDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId  = null;

    @Column(name = "total_use_amount")
    private int totalUseAmount;

    public ScrapTaxDetail(Long scrapId, int totalUseAmount) {
        this.scrapId = scrapId;
        this.totalUseAmount = totalUseAmount;
    }

    public static ScrapTaxDetail create(Scrap scrap, GetScrapTaxDetailDto taxDetailDto) {
        return new ScrapTaxDetail(scrap.getId(), Integer.parseInt(taxDetailDto.getTotalUseAmount()));
    }
}
