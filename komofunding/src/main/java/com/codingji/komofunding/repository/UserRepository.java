package com.codingji.komofunding.repository;

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

    // 페이징 처리된 목록 조회
    Page<User> findByUserIdIn(List<String> userIds, Pageable pageable);

    // 존재 여부 체크
    Boolean existsByEmail(String email);
    Boolean existsByNickName(String nickName);

}