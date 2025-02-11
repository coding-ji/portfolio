package com.codingji.komofunding.repository;

import com.codingji.komofunding.common.enums.QnaCategory;
import com.codingji.komofunding.entity.QnA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface QnARepository extends JpaRepository<QnA, String> {
    // 단건 조회
    Optional<QnA> findByQnaId(String qnaId);
    Optional<QnA> findByQnaNumber(Long qnaNumber);
    Optional<QnA> findByQnaNumberAndUserId(Long qnaNumber, String userId);
    Optional<QnA> findByTitle(String title); // 제목 정확히 일치

    // 페이징 처리된 목록 조회
    Page<QnA> findByUserId(String userId, Pageable pageable);
    Page<QnA> findByUserIdAndQnaCategory(String userId, QnaCategory qnaCategory, Pageable pageable);
    Page<QnA> findByQnaCategory(QnaCategory qnaCategory, Pageable pageable);
    Page<QnA> findByTitleContaining(String keyword, Pageable pageable);
    Page<QnA> findByWrittenDate(LocalDateTime writtenDate, Pageable pageable);
    // 리스트 조회 (페이징 필요 없는 경우)
    List<QnA> findAllByQnaIdIn(List<String> qnaIdList);

    // 존재 여부 체크
    Boolean existsByQnaNumber(Long qnaNumber);
}
