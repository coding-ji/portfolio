package com.codingji.komofunding.dto;

import com.codingji.komofunding.common.dto.ItemDTO;
import com.codingji.komofunding.common.enums.ProjectCategory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ProjectOutDTO {
    // 프로젝트 작성 유저 관련 정보 (userId로 찾아오기)
    private Long userNum;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String userShortDescription;
    private String profileImg;

    // 프로젝트 관련 정보
    private Long projectNum;
    private String title;
    private ProjectCategory projectCategory;
    private List<String> thumbnailImgs;
    private String projectShortDescription;
    private String description;
    private List<ItemDTO> items;
    private Long currentAmount;
    private Long totalAmount;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
    private LocalDateTime writtenDate;
    private LocalDateTime approvalDate;
    private LocalDateTime rejectionDate;
    private Boolean isHidden;
    private Double progressRate; // 달성률

    //프로젝트 문의댓글
    private List<QnAOutDTO> qnaList;
}
