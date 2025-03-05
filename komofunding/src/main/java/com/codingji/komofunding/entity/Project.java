package com.codingji.komofunding.entity;

import com.codingji.komofunding.common.dto.ItemDTO;
import com.codingji.komofunding.common.enums.ProjectCategory;
import com.codingji.komofunding.converter.ItemListConverter;
import com.codingji.komofunding.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "PROJECT",
        indexes = {
                @Index(name = "idx_project_num", columnList = "project_num"),
                @Index(name ="idx_user_id", columnList = "user_id"),
                @Index(name="idx_written_date", columnList = "written_date")
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "project_id", nullable = false, updatable = false, length = 36)
    private String projectId; // 프로젝트 UID

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId; // 프로젝트 작성자아이디

    @Column(name = "project_num", nullable = false, unique = true, updatable = false)
    private Long projectNum; // 프로젝트 번호 (자동 생성, 6자리)

    @Column(name = "title", nullable = false, length = 100)
    private String title; // 프로젝트 제목

    @Column(name="project_category")
    @Enumerated(EnumType.STRING)
    private ProjectCategory projectCategory; // 프로젝트 카테고리

    @Column(name="thumbnail_imgs", columnDefinition = "LONGTEXT")
    @Convert(converter = StringListConverter.class)
    private List<String> thumbnailImgs; // 프로젝트 썸네일 이미지

    @Column(name = "short_description", nullable = false, length = 150)
    private String shortDescription; // 프로젝트 짧은 소개

    @Column(name = "description", nullable = false)
    private String description; // 프로젝트 긴 소개가 담겨있는 html 파일주소

    @Convert(converter = ItemListConverter.class)
    @Column(name = "items", columnDefinition = "longtext")
    private List<ItemDTO> items; // 프로젝트 상세 상품

    @Column(name = "current_amount", nullable = false)
    private Long currentAmount;  // 현재 금액

    @Column(name = "total_amount", nullable = false)
    private Long totalAmount; // 총 금액

    @Column(name = "project_start_date", nullable = false)
    private LocalDateTime projectStartDate; // 프로젝트 후원 시작날

    @Column(name = "project_end_date", nullable = false)
    private LocalDateTime projectEndDate; // 프로젝트 후원 마감날

    @Column(name = "written_date", nullable = false, updatable = false)
    private LocalDateTime writtenDate; // 작성일

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate; // 글 업데이트 일

    @Column(name = "approval_date")
    private LocalDateTime approvalDate; // 프로젝트 승인 날짜

    @Column(name = "rejection_date")
    private LocalDateTime rejectionDate; // 프로젝트 거부날짜

    @Column(name = "is_hidden", nullable = false)
    private Boolean isHidden; // 숨김 여부 (승인 후에 isHidden이 false로 변경)

    @Column(name = "status_change_reason")
    private String statusChangeReason; // 거부 / 숨김인 이유

    @Convert(converter = StringListConverter.class)
    @Column(name = "qna_id_list", columnDefinition = "LONGTEXT")
    private List<String> qnaIdList; // 프로젝트 내에 문의댓글

    @Convert(converter = StringListConverter.class)
    @Column(name = "supporters_id_list", columnDefinition = "LONGTEXT")
    private List<String> supportersIdList; // 프로젝트 후원자목록

    @Builder(toBuilder = true)
    private Project(String projectId, String userId, Long projectNum, String title, ProjectCategory projectCategory, List<String> thumbnailImgs, String shortDescription, String description, List<ItemDTO> items, Long currentAmount, Long totalAmount, LocalDateTime projectStartDate, LocalDateTime projectEndDate, LocalDateTime writtenDate, LocalDateTime updatedDate, LocalDateTime approvalDate, LocalDateTime rejectionDate, Boolean isHidden, String statusChangeReason, List<String> qnaIdList, List<String> supportersIdList) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(projectCategory, "project category must not be null");
        Assert.notNull(shortDescription, "short description must not be null");
        Assert.notNull(description, "description must not be null");
        Assert.notNull(items, "items must not be null");

        this.projectId = projectId;
        this.userId = userId;
        this.projectNum = projectNum;
        this.title = title;
        this.projectCategory = projectCategory;
        this.thumbnailImgs = thumbnailImgs;
        this.shortDescription = shortDescription;
        this.description = description;
        this.items = items;
        this.currentAmount = (currentAmount != null) ? currentAmount : 0L; // 기본값 : 0원
        this.totalAmount = totalAmount;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.writtenDate = writtenDate;
        this.updatedDate = updatedDate;
        this.approvalDate = approvalDate;
        this.rejectionDate = rejectionDate;
        this.isHidden = (isHidden != null) ? isHidden : true; // 기본값 : true (승인 후 false로 변경)
        this.statusChangeReason = statusChangeReason;
        this.qnaIdList = (qnaIdList != null) ? qnaIdList : new ArrayList<>();
        this.supportersIdList = (supportersIdList != null) ? supportersIdList : new ArrayList<>();
    }
}