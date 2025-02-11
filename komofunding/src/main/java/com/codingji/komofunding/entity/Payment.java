package com.codingji.komofunding.entity;

import com.codingji.komofunding.common.dto.ItemDTO;
import com.codingji.komofunding.converter.ItemListConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "PAYMENT",
        indexes = {
                @Index(name = "idx_project_id", columnList = "project_id"),
                @Index(name ="idx_user_id", columnList = "user_id")
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false, updatable = false)
    private String paymentId; // 결제 ID - 포트원API와 연결되는 ID

    @Column(name = "payment_num", nullable = false, unique = true, updatable = false)
    private Long paymentNum; // 결제 번호

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId; // 유저 ID

    @Column(name = "project_id", nullable = false, updatable = false)
    private String projectId; // 프로젝트 ID

    @Convert(converter = ItemListConverter.class)
    @Column(name = "items", nullable = false, columnDefinition = "longtext")
    private List<ItemDTO> items; // 결제할 상품

    @Column(name = "paid_amount", nullable = false, updatable = false)
    private Long paidAmount; // 결제 금액

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate; // 결제 일시

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod; // 결제 방법

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // 결제 승인

    @Column(name = "failure_reason")
    private String failureReason; // 거절 이유

    @Column(name = "sender_name")
    private String senderName; // 배송자 이름

    @Column(name = "shipping_name")
    private String shippingName; // 받는 사람 이름

    @Column(name = "shipping_phone")
    private String shippingPhone; // 받는 사람 핸드폰 번호

    @Column(name = "shipping_address")
    private String shippingAddress; // 받는 사람 주소

    @Column(name = "refund_bank_name")
    private String refundBankName; // 환불 은행

    @Column(name = "refund_account_holder")
    private String refundAccountHolder; // 환불 예금주

    @Column(name = "refund_account_number")
    private String refundAccountNumber; // 환불 계좌 번호

    @Column(name = "is_refunded")
    private Boolean isRefunded; // 환불 여부

    @Builder
    public Payment(String paymentId, Long paymentNum, String userId, String projectId, List<ItemDTO> items, Long paidAmount, LocalDateTime paymentDate, String paymentMethod, String paymentStatus, String failureReason, String senderName, String shippingName, String shippingPhone, String shippingAddress, String refundBankName, String refundAccountHolder, String refundAccountNumber, Boolean isRefunded) {
        Assert.notNull(items, "items must not be null");
        Assert.notNull(paidAmount, "paidAmount must not be null");

        this.paymentId = paymentId;
        this.paymentNum = paymentNum;
        this.userId = userId;
        this.projectId = projectId;
        this.items = items;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.failureReason = failureReason;
        this.senderName = senderName;
        this.shippingName = shippingName;
        this.shippingPhone = shippingPhone;
        this.shippingAddress = shippingAddress;
        this.refundBankName = refundBankName;
        this.refundAccountHolder = refundAccountHolder;
        this.refundAccountNumber = refundAccountNumber;
        this.isRefunded = isRefunded;
    }
}