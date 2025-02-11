package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class UserOutDTO {
    private Long userNum;
    private String email;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String profileImg;
    private String shortDescription;
    private UserStatus activatedStatus;
    private String bankName;
    private String accountNumber;
    private String accountHolder;
    private LocalDateTime joinDate;
    private String corporationName;
    private String corporationTel;
    private String BSN;
    private List<String> projectIds;
}
