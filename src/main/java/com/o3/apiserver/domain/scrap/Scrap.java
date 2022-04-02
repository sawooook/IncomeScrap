package com.o3.apiserver.domain.scrap;

import com.o3.apiserver.domain.scrap.type.ScrapType;
import com.o3.apiserver.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scrap")
@NoArgsConstructor
@Getter
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ScrapType type;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "svcCd")
    private String svcCd;

    @Column(name = "app_version")
    private String appVersion;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "worker_response_at")
    private LocalDateTime workerResponseAt;

    @Column(name = "worker_request_at")
    private LocalDateTime workerRequestAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
