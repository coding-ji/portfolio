package com.codingji.komofunding.entity;

import com.codingji.komofunding.common.enums.UserStatus;
import com.codingji.komofunding.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "USER",
        indexes = {
                @Index(name = "idx_user_num", columnList = "user_num"),
                @Index(name = "idx_email", columnList = "email"),
                @Index(name = "idx_name", columnList = "name"),
                @Index(name = "idx_nick_name", columnList = "nick_name"),
                @Index(name = "idx_phone_number", columnList = "phone_number"),
                @Index(name = "idx_activated_status", columnList = "activated_status")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false, updatable = false, length = 36)
    private String userId;  // 자동 생성되는 유저 고유 ID

    @Column(name = "user_num", nullable = false, unique = true)
    private Long userNum; // 자동 생성되는 유저 번호

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; // 유저 이메일 및 유저 로그인 시 아이디

    @Column(name = "password", nullable = false)
    private String password; // 유저 비밀번호

    @Column(name = "name", length = 20)
    private String name;  // 유저 이름

    @Column(name = "nick_name", unique = true, length = 20)
    private String nickName;  // 유저 별명

    @Column(name = "phone_number", unique = true, length = 20)
    private String phoneNumber; // 유저 핸드폰 번호

    @Column(name = "profile_img", length = 255)
    private String profileImg; // 프로필 이미지

    @Column(name = "short_description", length = 100)
    private String shortDescription; // 유저 짧은 소개글

    @Column(name = "activated_status", columnDefinition = "varchar(255) default 'DONOR'") // 기본값 : DONOR("후원자")
    @Enumerated(EnumType.STRING)
    private UserStatus activatedStatus;  // 유저의 활동(후원자, 제작자 대기, 제작자), 탈퇴, 정지 상태

    @Column(name = "deactivation_reason", length = 200)
    private String deactivationReason; // 유저 탈퇴 혹은 정지 사유

    @Column(name = "deactivation_date")
    private LocalDateTime deactivationDate; // 탈퇴 날짜

    @Column(name = "bank_name", length = 50)
    private String bankName; // 은행명

    @Column(name = "account_number", length = 50)
    private String accountNumber; // 은행 계좌 번호

    @Column(name = "account_holder", length = 50)
    private String accountHolder; // 예금주

    @Column(name = "join_date", nullable = false)
    private LocalDateTime joinDate;  // 가입 날짜

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime; // 최종 로그인 시간

    @Column(name = "corporation_name", length = 100)
    private String corporationName; // 사업자명

    @Column(name = "corporation_tel", length = 100)
    private String corporationTel; // 사업자 전화번호

    @Column(name = "bsn", length = 100)
    private String BSN; // 사업자 등록 번호

    @Column(name = "project_ids", columnDefinition = "longtext")
    @Convert(converter = StringListConverter.class)
    private List<String> projectIds; // 작성한 프로젝트 UID

    @Column(name = "privacy_agreement")
    private Boolean privacyAgreement; // 개인정보 동의 여부

    @Builder(toBuilder = true)
    public User(String userId, Long userNum, String email, String password, String name, String nickName, String phoneNumber, String profileImg, String shortDescription, UserStatus activatedStatus, String deactivationReason, LocalDateTime deactivationDate, String bankName, String accountNumber, String accountHolder, LocalDateTime joinDate, LocalDateTime lastLoginTime, String corporationName, String corporationTel, String BSN, List<String> projectIds, Boolean privacyAgreement) {
        Assert.notNull(email, "email must not be null");
        Assert.notNull(password, "password must not be null");

        this.userId = userId;
        this.userNum = userNum;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.profileImg = profileImg;
        this.shortDescription = shortDescription;
        this.activatedStatus = activatedStatus;
        this.deactivationReason = deactivationReason;
        this.deactivationDate = deactivationDate;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.joinDate = joinDate;
        this.lastLoginTime = lastLoginTime;
        this.corporationName = corporationName;
        this.corporationTel = corporationTel;
        this.BSN = BSN;
        this.projectIds = (projectIds != null) ? projectIds : new ArrayList<>();
        this.privacyAgreement = (privacyAgreement != null) ? privacyAgreement : false;  // 초기값 : 동의하지않음
    }
}