package com.codingji.komofunding.converter;

import com.codingji.komofunding.dto.PaymentInDTO;
import com.codingji.komofunding.dto.PaymentOutDTO;
import com.codingji.komofunding.entity.Payment;
import com.codingji.komofunding.entity.Project;
import com.codingji.komofunding.entity.User;
import com.codingji.komofunding.exception.CustomErrorCode;
import com.codingji.komofunding.exception.CustomException;
import com.codingji.komofunding.repository.ProjectRepository;
import com.codingji.komofunding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentConverter {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public PaymentOutDTO toOutDTO(Payment payment) {
        // 사용자 정보
        User user = userRepository.findById(payment.getUserId())
                .orElseThrow(() -> new CustomException(CustomErrorCode.ACCOUNT_NOT_FOUND));

        // 프로젝트 정보
        Project project = projectRepository.findById(payment.getProjectId())
                .orElseThrow(() -> new CustomException(CustomErrorCode.PROJECT_NOT_FOUND));

        return PaymentOutDTO.builder()
                .userNum(user.getUserNum())
                .nickName(user.getNickName())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .bankName(user.getBankName())
                .accountNumber(user.getAccountNumber())
                .accountHolder(user.getAccountHolder())

                // 결제 관련 정보
                .paymentId(payment.getPaymentId())
                .paymentNum(String.valueOf(payment.getPaymentNum()))
                .items(payment.getItems())
                .paidAmount(payment.getPaidAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .failureReason(payment.getFailureReason())
                .senderName(payment.getSenderName())
                .shippingName(payment.getShippingName())
                .shippingPhone(payment.getShippingPhone())
                .shippingAddress(payment.getShippingAddress())
                .refundBankName(payment.getRefundBankName())
                .refundAccountHolder(payment.getRefundAccountHolder())
                .refundAccountNumber(payment.getRefundAccountNumber())
                .isRefunded(payment.getIsRefunded())

                // 프로젝트 관련
                .thumbnailImgs(project.getThumbnailImgs())
                .title(project.getTitle())
                .shortDescription(project.getShortDescription())
                .startDate(project.getProjectStartDate())
                .endDate(project.getProjectEndDate())
                .projectNum(project.getProjectNum())
                .build();
    }

    public Payment toEntity(PaymentInDTO paymentInDTO) {
        return Payment.builder()
                .items(paymentInDTO.getItems())
                .paidAmount(paymentInDTO.getPaidAmount())
                .paymentDate(paymentInDTO.getPaymentDate())
                .paymentMethod(paymentInDTO.getPaymentMethod())
                .paymentStatus(paymentInDTO.getPaymentStatus())
                .failureReason(paymentInDTO.getFailureReason())
                .senderName(paymentInDTO.getSenderName())
                .shippingName(paymentInDTO.getShippingName())
                .shippingPhone(paymentInDTO.getShippingPhone())
                .shippingAddress(paymentInDTO.getShippingAddress())
                .refundBankName(paymentInDTO.getRefundBankName())
                .refundAccountHolder(paymentInDTO.getRefundAccountHolder())
                .refundAccountNumber(paymentInDTO.getRefundAccountNumber())
                .isRefunded(paymentInDTO.getIsRefunded())
                .build();
    }
}
