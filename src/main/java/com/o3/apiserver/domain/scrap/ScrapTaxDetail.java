package com.o3.apiserver.domain.scrap;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "scrap_calculate_tax_detail")
@NoArgsConstructor
public class ScrapCalculateTaxDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrap_id;

    @Column(name = "total_use_amount")
    private int totalUseAmount;
}
