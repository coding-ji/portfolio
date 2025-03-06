package com.codingji.komofunding.entity;

import com.codingji.komofunding.common.enums.QnaCategory;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "QNA",
        indexes = {
                @Index(name = "idx_user_id", columnList = "user_id"),
                @Index(name = "idx_qna_category", columnList = "qna_category"),
                @Index(name = "idx_qna_written_date", columnList = "written_date"),
                @Index(name = "idx_qna_number", columnList = "qna_number")
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QnA {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "qna_id", nullable = false, updatable = false)
    private String qnaId; // 문의글 id

    @Column(name="qna_number", nullable = false, unique = true)
    private Long qnaNumber; // 문의글 번호 (자동생성, 6자리)

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId; //문의글을 작성한 userId

    @Enumerated(EnumType.STRING)
    @Column(name = "qna_category")
    private QnaCategory qnaCategory; // 문의글 카테고리

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "question_comment")
    private String question_comment;  // 문의글 내용

    @Column(name = "written_date", nullable = false, updatable = false)
    private LocalDateTime writtenDate;  // 질문글 작성날짜

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate; // 질문글 업데이트 날짜

    @Column(name="answer_user_id")
    private String answerUserId; // 문의답변 작성한 userId

    @Column(name="answer")
    private String answer; // 문의 답변

    @Column(name = "answer_written_date")
    private LocalDateTime answerWrittenDate; // 문의 답변작성날짜

    @Column(name = "answer_updated_date")
    private LocalDateTime answerUpdatedDate; // 문의 답변 수정 날짜

    @Builder(toBuilder = true)
    private QnA(String qnaId, Long qnaNumber, String userId, QnaCategory qnaCategory, String title, String question_comment, LocalDateTime writtenDate, LocalDateTime updatedDate, String answerUserId, String answer, LocalDateTime answerWrittenDate, LocalDateTime answerUpdatedDate) {
        Assert.notNull(question_comment, "question comment must not be null");

        this.qnaId = qnaId;
        this.qnaNumber = qnaNumber;
        this.userId = userId;
        this.qnaCategory = qnaCategory;
        this.title = (title != null) ? title : "제목이 없습니다.";  // 1:1 문의는 제목 필요, 댓글 문의는 제목 필요 없음
        this.question_comment = question_comment;
        this.writtenDate = writtenDate;
        this.updatedDate = updatedDate;
        this.answerUserId = answerUserId;
        this.answer = (answer != null) ? answer : "-"; // 답변 기본값 "-"
        this.answerWrittenDate = answerWrittenDate;
        this.answerUpdatedDate = answerUpdatedDate;
    }
}