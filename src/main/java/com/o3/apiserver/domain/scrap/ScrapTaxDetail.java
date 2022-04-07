package com.o3.apiserver.domain.scrap;


import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scrap_tax_detail")
@NoArgsConstructor
@Getter
public class ScrapTaxDetail {

    @Id
    @Column(name = "scrap_id")
    private Long scrapId;

    @Column(name = "total_use_amount")
    private int totalUseAmount;

    public ScrapTaxDetail(Long scrapId, int totalUseAmount) {
        this.scrapId = scrapId;
        this.totalUseAmount = totalUseAmount;
    }

    public static ScrapTaxDetail create(Scrap scrap, GetScrapTaxDetailDto response) {
        return new ScrapTaxDetail(scrap.getId(), Integer.parseInt(response.getTotalUseAmount()));
    }
}
