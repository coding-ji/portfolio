package com.codingji.komofunding.repository;

import com.codingji.komofunding.entity.Payment;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    // 단건조회
    Optional<Payment> findByPaymentId(String paymentId);

    // 페이징 처리된 목록 조회
    Page<Payment> findByProjectId(String projectId, Pageable pageable);
    Page<Payment> findByUserId(String userId, Pageable pageable);
    Page<Payment> findByIsRefunded(Boolean isRefunded, Pageable pageable);

    // 존재 여부 체크
    Boolean existsByPaymentNum(Long paymentNum);
}