package com.codingji.komofunding.converter;

import com.codingji.komofunding.dto.QnAInDTO;
import com.codingji.komofunding.dto.QnAOutDTO;
import com.codingji.komofunding.entity.QnA;
import com.codingji.komofunding.entity.User;
import com.codingji.komofunding.exception.CustomErrorCode;
import com.codingji.komofunding.exception.CustomException;
import com.codingji.komofunding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QnAConverter {

    private final UserRepository userRepository;

    public QnAOutDTO toOutDTO(QnA qna) {
        // 작성자
        User writer = userRepository.findById(qna.getUserId())
                .orElseThrow(() -> new CustomException(CustomErrorCode.ACCOUNT_NOT_FOUND));

        // 답변자
        User responder = null;
        if (qna.getAnswerUserId() != null) {
            responder = userRepository.findById(qna.getAnswerUserId())
                    .orElseThrow(() -> new CustomException(CustomErrorCode.ACCOUNT_NOT_FOUND));
        }

        return QnAOutDTO.builder()
                .qnaCategory(qna.getQnaCategory())
                .qnaNumber(qna.getQnaNumber())
                .nickName(writer.getNickName())
                .userNum(writer.getUserNum())
                .writtenDate(qna.getWrittenDate())
                // title은 댓글일 경우에는 null값 허용
                .title(qna.getTitle() != null ? qna.getTitle() : null)
                .questionComment(qna.getQuestion_comment())
                // answer이 없을 경우에는 null 값 설정
                .answerNickName(responder != null ? responder.getNickName() : null)
                .answerNum(responder != null ? responder.getUserNum() : null)
                .answerWrittenDate(qna.getAnswerWrittenDate())
                .answer(qna.getAnswer())
                .build();
    }

    public QnA toEntity(QnAInDTO qnAInDTO) {
        return QnA.builder()
                .userId(qnAInDTO.getUserId())
                .qnaCategory(qnAInDTO.getQnaCategory())
                .title(qnAInDTO.getTitle())
                .question_comment(qnAInDTO.getQuestionComment())
                .answerUserId(qnAInDTO.getAnswerUserId())
                .answer(qnAInDTO.getAnswer())
                .build();
    }
}
