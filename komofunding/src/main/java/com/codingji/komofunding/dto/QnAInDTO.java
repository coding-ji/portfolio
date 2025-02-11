package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.enums.QnaCategory;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class QnAInDTO {
    private String userId; // 작성자 userId

    @NotNull
    private QnaCategory qnaCategory; // 문의글 카테고리 (프로젝트 댓글에 적을때는 COMMENT, 1:1문의는 QUESTION)

    @Size(max = 100, message = "문의글 제목은 최대 100자까지 입력 가능합니다.")
    private String title; // 문의글 제목 ( 댓글일 경우에는 null 값 허용 )

    @NotBlank(message = "문의글을 작성해주세요.")
    @Size(min = 10, max = 1000, message = "문의글 내용은 최소 10자 이상, 최대 1000자까지 입력 가능합니다.")
    private String questionComment; // 문의글 내용

    private String answerUserId; //답변자 userId

    @Size(max = 1000, message = "답변 내용은 최대 1000자까지 입력 가능합니다.")
    private String answer; // 문의 답변

    // QUESTION이 아니라면 true반환, QUESTION이면 title 작성
    @AssertTrue(message = "1:1 문의글 제목을 작성해주세요.")
    private boolean isTitleValid() {
        return qnaCategory != QnaCategory.QUESTION || (title != null && !title.trim().isEmpty());
    }
}
