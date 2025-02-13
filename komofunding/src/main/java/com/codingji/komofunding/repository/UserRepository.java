package com.codingji.komofunding.repository;

import com.codingji.komofunding.common.enums.UserStatus;
import com.codingji.komofunding.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // 단건 조회
    Optional<User> findById(String userId);
    Optional<User> findByEmail(String email);
    Optional<User> findByNameAndPhoneNumber(String name, String phoneNumber);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByUserNum(Long userNum);
    Optional<User> findByNickName(String nickName);
    Optional<User> findByPhoneNumber(String phoneNumber);

    // 페이징 처리된 목록 조회
    Page<User> findByUserIdIn(List<String> userIds, Pageable pageable);
    Page<User> findByActivatedStatus(UserStatus activatedStatus, Pageable pageable);
    Page<User> findByActivatedStatusIn(List<UserStatus> activatedStatuses, Pageable pageable);

    // 리스트 조회
    List<User> findAllByUserIdIn(List<String> userIds);

    // 존재 여부 체크
    Boolean existsByEmail(String email);
    Boolean existsByNickName(String nickName);
    Boolean existsByUserNumber(Long userNum);
}