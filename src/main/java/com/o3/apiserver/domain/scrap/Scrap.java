package com.o3.apiserver.domain.scrap;

import com.o3.apiserver.application.scrap.dto.GetScrapDto;
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
    private Long id = null;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_unique_id")
    private User user;

    @Column(name = "created_at")
    private LocalDateTime createdΩAt = LocalDateTime.now();

    public Scrap(String errorMessage, String companyName,
                 String svcCd, String appVersion, String hostName,
                 LocalDateTime workerResponseAt, LocalDateTime workerRequestAt,
                 User user) {
        this.user = user;
        this.errorMessage = errorMessage;
        this.companyName = companyName;
        this.svcCd = svcCd;
        this.appVersion = appVersion;
        this.hostName = hostName;
        this.workerResponseAt = workerResponseAt;
        this.workerRequestAt = workerRequestAt;
    }

    public Scrap(Long id, String errorMessage, String companyName, String svcCd,
                 String appVersion, String hostName, LocalDateTime workerResponseAt,
                 LocalDateTime workerRequestAt, User user) {
        this.id = id;
        this.errorMessage = errorMessage;
        this.companyName = companyName;
        this.svcCd = svcCd;
        this.appVersion = appVersion;
        this.hostName = hostName;
        this.workerResponseAt = workerResponseAt;
        this.workerRequestAt = workerRequestAt;
        this.user = user;
    }

    public static Scrap create(GetScrapDto response, User user) {
        return new Scrap(
                response.getResultResponse().getErrorMessage(),
                response.getResultResponse().getCompany(),
                response.getResultResponse().getSvcCd(),
                response.getAppVersion(),
                response.getHostName(),
                response.getWorkerResponseDateTime(),
                response.getWorkerRequestDateTime(),
                user
        );
    }
}
