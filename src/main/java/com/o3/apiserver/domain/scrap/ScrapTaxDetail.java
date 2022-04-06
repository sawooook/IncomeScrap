package com.o3.apiserver.domain.scrap;


import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyTaxDetailResponse;
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
    private Long scrapId;

    @Column(name = "total_use_amount")
    private int totalUseAmount;

    public ScrapTaxDetail(Long scrapId, int totalUseAmount) {
        this.scrapId = scrapId;
        this.totalUseAmount = totalUseAmount;
    }

    public static ScrapTaxDetail create(Scrap scrap, ThirdPartyTaxDetailResponse response) {
        return new ScrapTaxDetail(scrap.getId(), Integer.parseInt(response.getTotalUseAmount()));
    }
}
