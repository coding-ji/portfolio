package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.enums.UserStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserOutDTO {
    private Long userNum;
    private String email;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String profileImg;
    private String shortDescription;
    private UserStatus activatedStatus;
    private String deactivationReason;
    private LocalDateTime deactivationDate;
    private LocalDateTime joinDate;
    private LocalDateTime lastLoginTime;
    private List<String> projectIds;
}
