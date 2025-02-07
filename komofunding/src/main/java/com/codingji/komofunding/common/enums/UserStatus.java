package com.codingji.komofunding.common.enums;

public enum UserStatus {
    // DONOR(후원자), CREATORPENDING(제작자신청중), CREATOR(제작자)의 경우에는 활동회원
    DONOR("후원자"),
    CREATORPENDING("제작자 신청 중"),
    CREATOR("제작자"),

    // 탈퇴회원
    DEACTIVATED("탈퇴회원"),

    // 정지회원
    SUSPENDED("정지회원");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
