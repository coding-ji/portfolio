package com.codingji.komofunding.repository;

import com.codingji.komofunding.common.enums.ProjectCategory;
import com.codingji.komofunding.entity.Project;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    // 단건조회
    Optional<Project> findByProjectId(String projectId);
    Optional<Project> findByProjectNum(Long projectNum);
    Optional<Project> findByTitle(String title); // 제목 정확히 일치

    // 페이징 처리된 목록 조회  (Page : 관리자페이지에서 사용, Slice : 유저페이지에서 사용)
    Page<Project> findByUserId(String userId, Pageable pageable);
    Page<Project> findByTitleContaining(String keyword, Pageable pageable); // 제목 포함
    Page<Project> findByWrittenDate(LocalDateTime writtenDate, Pageable pageable); // 작성일자 정확히 일치
    // 특정 날짜 범위 내에 프로젝트 시작 날짜가 포함된 프로젝트 조회
    Page<Project> findByProjectStartDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    // 특정 날짜 범위 내에 프로젝트 종료 날짜가 포함된 프로젝트 조회
    Page<Project> findByProjectEndDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    // 특정 날짜 범위 안에 프로젝트 전체 기간(시작~종료)이 완전히 포함된 프로젝트 조회
    Page<Project> findByProjectStartDateAfterAndProjectEndDateBefore(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    // 마감된 프로젝트
    Page<Project> findByProjectEndDateBefore(LocalDateTime today, Pageable pageable);
    Page<Project> findByIsHidden(Boolean isHidden, Pageable pageable); // 프로젝트 숨김 여부

    // fundingStatus에 따른 조회
    // 전체 프로젝트 조회 - HOME
    Page<Project> findAllProjects(Pageable pageable); // 관리자페이지에서 사용
    Slice<Project> findAllSliceProjects(Pageable pageable); // HOME에서 사용
    // 진행 중인 프로젝트 조회 (오늘을 기준으로 시작 날짜가 이전이고, 종료 날짜가 이후) - ONGOING (ACTIVE)
    Slice<Project> findByProjectStartDateBeforeAndProjectEndDateAfter(LocalDateTime now, Pageable pageable);
    // 예정 중인 프로젝트 조회 (오늘을 기준으로 시작 날짜가 이후) - UPCOMING
    Slice<Project> findByProjectStartDateAfter(LocalDateTime now, Pageable pageable);

    // fundingStatus와 projectCategory에 따른 조회
    // 전체 프로젝트 & 카테고리
    Page<Project> findByPageProjectCategory(ProjectCategory category, Pageable pageable);
    Slice<Project> findByProjectCategory(ProjectCategory category, Pageable pageable);
    // 진행 프로젝트 & 카테고리
    Slice<Project> findByProjectStartDateBeforeAndProjectEndDateAfterAndProjectCategory(LocalDateTime now, ProjectCategory category, Pageable pageable);
    // 예정 프로젝트 & 카테고리
    Slice<Project> findByProjectStartDateAfterAndProjectCategory(LocalDateTime now, ProjectCategory category, Pageable pageable);

    // 존재 여부 체크
    Boolean existsByProjectNum(Long projectNum);
}
