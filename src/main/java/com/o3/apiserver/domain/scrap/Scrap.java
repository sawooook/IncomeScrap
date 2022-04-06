package com.o3.apiserver.domain.scrap;

import com.o3.apiserver.domain.user.User;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
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
    private LocalDateTime createdAt;


    public Scrap(String userUniqueId, String errorMessage, String companyName, String svcCd, String appVersion, String hostName, LocalDateTime workerResponseAt, LocalDateTime workerRequestAt) {
        this.userUniqueId = userUniqueId;
        this.errorMessage = errorMessage;
        this.companyName = companyName;
        this.svcCd = svcCd;
        this.appVersion = appVersion;
        this.hostName = hostName;
        this.workerResponseAt = workerResponseAt;
        this.workerRequestAt = workerRequestAt;
        this.createdAt = LocalDateTime.now();
    }


    public static Scrap create(ThirdPartyResponse response, User user) {
        return new Scrap(
                user.getUserUniqueId(),
                response.getResponse().getErrorMessage(),
                response.getResponse().getCompany(),
                response.getResponse().getScvCd(),
                response.getAppVersion(),
                response.getHostName(),
                response.getWorkerResponseDateTime(),
                response.getWorkerRequestDateTime()
        );
    }
}
