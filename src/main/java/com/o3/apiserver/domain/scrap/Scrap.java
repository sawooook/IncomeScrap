package com.o3.apiserver.domain.scrap;

import com.o3.apiserver.application.scrap.dto.GetScrapDto;
import com.o3.apiserver.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

    @Column(name = "user_id")
    private String userUniqueId;

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
    private LocalDateTime createdAt = LocalDateTime.now();

    public Scrap(String userUniqueId, String errorMessage, String companyName,
                 String svcCd, String appVersion, String hostName,
                 LocalDateTime workerResponseAt, LocalDateTime workerRequestAt
    ) {
        this.userUniqueId = userUniqueId;
        this.errorMessage = errorMessage;
        this.companyName = companyName;
        this.svcCd = svcCd;
        this.appVersion = appVersion;
        this.hostName = hostName;
        this.workerResponseAt = workerResponseAt;
        this.workerRequestAt = workerRequestAt;
    }

    public static Scrap create(GetScrapDto response, User user) {
        return new Scrap(
                user.getUserUniqueId(),
                response.getResultResponse().getErrorMessage(),
                response.getResultResponse().getCompany(),
                response.getResultResponse().getSvcCd(),
                response.getAppVersion(),
                response.getHostName(),
                response.getWorkerResponseDateTime(),
                response.getWorkerRequestDateTime()
        );
    }
}
