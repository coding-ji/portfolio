package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.dto.ItemDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PaymentInDTO {
    private String paymentId;

    private String paymentNum;

    private String userId;

    private String projectId;

    @NotNull(message = "아이템 목록은 필수 입력입니다.")
    @Size(min = 1, message = "아이템 목록은 최소 1개 이상의 아이템이 필요합니다.")
    @Valid
    private List<ItemDTO> items;

    @NotNull(message = "지불 금액은 필수 입력입니다.")
    @Min(value = 1, message = "지불 금액은 1원 이상이어야 합니다.")
    private Long paidAmount;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    private String paymentStatus;

    private String failureReason;

    @NotBlank(message = "보내는 사람은 필수 입력값입니다.")
    @Size(max = 50, message = "보내는 사람은 최대 50자까지 입력 가능합니다.")
    private String senderName;

    @NotBlank(message = "받는 사람은 필수 입력값입니다.")
    @Size(max = 50, message = "받는 사람은 최대 50자까지 입력 가능합니다.")
    private String shippingName;

    @Pattern(
            regexp = "^[0-9]{8,15}$",
            message = "핸드폰 번호는 숫자만 입력해주세요. 최대 15자까지 입력 가능합니다."
    )
    private String shippingPhone;

    @NotBlank(message = "받는 주소는 필수 입력값입니다.")
    @Size(max = 50, message = "받는 주소는 최대 50자까지 입력 가능합니다.")
    private String shippingAddress;

    @NotBlank(message = "은행은 필수 입력값입니다.")
    private String refundBankName;

    @NotBlank(message = "예금주는 필수 입력값입니다.")
    @Size(max = 50, message = "예금주는 최대 50자까지 입력 가능합니다.")
    private String refundAccountHolder;

    @NotBlank(message = "환불 계좌번호는 필수 입력값입니다.")
    @Pattern(
            regexp = "^[0-9]{1,50}$",
            message = "계좌번호는 숫자만 입력해주세요. 최대 50자까지 입력 가능합니다."
    )
    private String refundAccountNumber;

    private Boolean isRefunded;
}
