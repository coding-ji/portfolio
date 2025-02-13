package com.codingji.komofunding.converter;

import com.codingji.komofunding.dto.*;
import com.codingji.komofunding.entity.Project;
import com.codingji.komofunding.entity.QnA;
import com.codingji.komofunding.entity.User;
import com.codingji.komofunding.exception.CustomErrorCode;
import com.codingji.komofunding.exception.CustomException;
import com.codingji.komofunding.repository.QnARepository;
import com.codingji.komofunding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectConverter {

    private final UserRepository userRepository;
    private final QnARepository qnARepository;
    private final QnAConverter qnAConverter;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");

    public ProjectOutDTO toOutDTO(Project project) {
        // 작성자
        User user = userRepository.findById(project.getUserId())
                .orElseThrow(() -> new CustomException(CustomErrorCode.ACCOUNT_NOT_FOUND));

        // QnA 리스트
        List<QnA> qnaEntities = Optional.ofNullable(project.getQnaIdList())
                .map(qnARepository::findAllByQnaIdIn)
                .orElse(Collections.emptyList());
        List<QnAOutDTO> qnaList = qnaEntities.stream()
                .map(qnAConverter::toOutDTO)
                .collect(Collectors.toList());

        // 달성률 계산(소수점 첫자리)
        Double progressRate = 0.0;
        if (project.getTotalAmount() != null && project.getTotalAmount() > 0) {
            progressRate = (project.getCurrentAmount() / (double) project.getTotalAmount()) * 100;
        }
        progressRate = Double.valueOf(DECIMAL_FORMAT.format(progressRate));

        return ProjectOutDTO.builder()
                .userNum(user.getUserNum())
                .nickname(user.getNickName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .userShortDescription(user.getShortDescription())
                .projectNum(project.getProjectNum())
                .title(project.getTitle())
                .projectCategory(project.getProjectCategory())
                .thumbnailImgs(project.getThumbnailImgs())
                .projectShortDescription(project.getShortDescription())
                .description(project.getDescription())
                .items(project.getItems())
                .currentAmount(project.getCurrentAmount())
                .totalAmount(project.getTotalAmount())
                .projectStartDate(project.getProjectStartDate())
                .projectEndDate(project.getProjectEndDate())
                .writtenDate(project.getWrittenDate())
                .approvalDate(project.getApprovalDate())
                .rejectionDate(project.getRejectionDate())
                .isHidden(project.getIsHidden())
                .qnaList(qnaList)
                .progressRate(progressRate)
                .build();
    }

    public Project toEntity(ProjectInDTO projectInDTO, User user) {
        // totalAmount 계산
        Long totalAmount = projectInDTO.getItems()
                .stream()
                .mapToLong(item -> item.itemPrice() * item.itemAmount())
                .sum();

        return Project.builder()
                .userId(user.getUserId())
                .title(projectInDTO.getTitle())
                .projectCategory(projectInDTO.getProjectCategory())
                .thumbnailImgs(projectInDTO.getThumnailImgs())
                .shortDescription(projectInDTO.getProjectShortDescription())
                .description(projectInDTO.getDescription())
                .items(projectInDTO.getItems())
                .totalAmount(totalAmount)
                .projectStartDate(projectInDTO.getProjectStartDate())
                .projectEndDate(projectInDTO.getProjectEndDate())
                .build();
    }
}