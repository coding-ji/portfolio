package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class UserInDTO {
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;

    // 영문자 최소 1개 이상, 숫자 최소 1개 이상, 특수문자(!@#$%^&*_-) 최소 1개 이상, 영문자, 숫자, 특수문자로 이루어진 8~20자 문자열
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*_-])[a-zA-Z\\d!@#$%^&*_-]{8,20}$",
            message = "비밀번호는 영문자, 숫자, 특수문자(!@#$%^&*_-)를 포함한 8~20자리여야 합니다."
    )
    private String password;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(max = 50, message = "이름은 최대 50자까지 입력 가능합니다.")
    private String name;

    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    @Size(max = 20, message = "닉네임은 최대 20자까지 입력 가능합니다.")
    private String nickName;

    private Long userNum;

    @Pattern(
            regexp = "^[0-9]{8,15}$",
            message = "핸드폰 번호는 숫자만 입력해주세요. 최대 15자까지 입력 가능합니다."
    )
    private String phoneNumber;

    private String profileImg;

    @Size(max = 100, message = "자기소개는 최대 100자까지 입력 가능합니다.")
    private String shortDescription;

    private UserStatus activatedStatus;

    @Size(max = 50, message = "은행명은 최대 50자까지 입력 가능합니다.")
    private String bankName;

    @Pattern(
            regexp = "^[0-9]{1,50}$",
            message = "계좌번호는 숫자만 입력해주세요. 최대 50자까지 입력 가능합니다."
    )
    private String accountNumber;

    @Size(max = 50, message = "예금주 명은 최대 50자까지 입력 가능합니다.")
    private String accountHolder;

    @Size(max = 100, message = "사업자 명은 최대 100자까지 입력 가능합니다.")
    private String corporationName;

    @Pattern(
            regexp = "^[0-9]{8,15}$",
            message = "사업자 전화번호는 숫자만 입력해주세요. 최대 15자까지 입력 가능합니다."
    )
    private String corporationTel;

    @Pattern(
            regexp = "^[0-9]{3}-[0-9]{2}-[0-9]{5}$",
            message = "사업자 등록번호는 XXX-XX-XXXXX 형식이어야 합니다."
    )
    private String BSN;

    private List<String> projectIds;
}
