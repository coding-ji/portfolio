package com.codingji.komofunding.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode {
    // 공통 에러
    INVALID_INPUT_VALUE(400, "COMMON-ERR-001", "잘못된 입력 형식입니다."),
    INTERNAL_SERVER_ERROR(500, "COMMON-ERR-002", "서버 오류가 발생하였습니다."),
    TIMEOUT_ERROR(408, "COMMON-ERR-003", "요청 시간이 초과되었습니다."),
    BAD_REQUEST(400, "COMMON-ERR-004", "잘못된 요청입니다."),
    RESOURCE_NOT_FOUND(404, "COMMON-ERR-005", "요청된 리소스를 찾을 수 없습니다."),
    UNSUPPORTED_MEDIA_TYPE(415, "COMMON-ERR-006", "지원되지 않는 파일 형식입니다."),

    // CRUD 공통 에러
    CREATION_FAILED(500, "FAILED_ERR_001", "생성에 실패했습니다."),
    UPDATE_FAILED(500, "FAILED_ERR_002", "수정에 실패했습니다."),
    DELETION_FAILED(500, "FAILED_ERR_003", "삭제에 실패했습니다."),

    // 계정 관련 에러
    UNAUTHORIZED(401, "ACCOUNT-ERR-001", "인증에 실패하였습니다."),
    ACCOUNT_NOT_FOUND(404, "ACCOUNT-ERR-002", "사용자를 찾을 수 없습니다."),
    ROLE_NOT_EXISTS(403, "ACCOUNT-ERR-003", "사용자 권한이 없습니다."),
    DUPLICATE_EMAIL(400, "ACCOUNT-ERR-OO4", "이미 존재하는 이메일입니다."),
    DUPLICATE_NICKNAME(400, "ACCOUNT-ERR-005","이미 존재하는 닉네임입니다."),
    PASSWORD_MISMATCH(400, "ACCOUNT-ERR-OO6", "비밀번호가 일치하지 않습니다."),
    USER_INACTIVE(403, "ACCOUNT-ERR-OO7", "비활성화된 사용자입니다."),

    // 프로젝트 관련 에러
    PROJECT_NOT_FOUND(404, "PROJECT_ERR_001", "프로젝트를 찾을 수 없습니다."),
    PROJECT_NOT_ACTIVE(400, "PROJECT_ERR_002", "활성화된 프로젝트가 아닙니다."),

    // 문의, 댓글 관련 에러
    COMMENT_NOT_FOUND(404, "COMMENT_ERR_001", "댓글을 찾을 수 없습니다."),
    INQUIRY_NOT_FOUND(404, "INQUIRY_ERR_001", "문의사항을 찾을 수 없습니다."),

    // 결제 관련 에러
    PAYMENT_FAILED(500, "PAYMENT_ERR_001", "결제에 실패했습니다."),
    PAYMENT_METHOD_NOT_SUPPORTED(400, "PAYMENT_ERR_002", "지원되지 않는 결제 방법입니다."),
    INSUFFICIENT_FUNDS(402, "PAYMENT_ERR_003", "잔액이 부족합니다."),
    PAYMENT_NOT_FOUND(404, "PAYMENT_ERR_004", "결제 정보를 찾을 수 없습니다."),
    PAYMENT_ALREADY_PROCESSED(409, "PAYMENT_ERR_005", "이미 결제가 처리되었습니다.");

    private final int status;
    private final String code;
    private final String message;

}