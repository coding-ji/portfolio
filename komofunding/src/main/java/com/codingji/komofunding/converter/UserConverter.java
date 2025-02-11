package com.codingji.komofunding.converter;

import com.codingji.komofunding.dto.UserInDTO;
import com.codingji.komofunding.dto.UserOutDTO;
import com.codingji.komofunding.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public static UserOutDTO toOutDTO(User user){
        return UserOutDTO.builder()
                .userNum(user.getUserNum())
                .email(user.getEmail())
                .name(user.getName())
                .nickName(user.getNickName())
                .phoneNumber(user.getPhoneNumber())
                .profileImg(user.getProfileImg())
                .shortDescription(user.getShortDescription())
                .activatedStatus(user.getActivatedStatus())
                .bankName(user.getBankName())
                .accountNumber(user.getAccountNumber())
                .accountHolder(user.getAccountHolder())
                .joinDate(user.getJoinDate())
                .corporationName(user.getCorporationName())
                .corporationTel(user.getCorporationTel())
                .BSN(user.getBSN())
                .projectIds(user.getProjectIds())
                .build();
    }

    public static User toEntity(UserInDTO userInDTO){
        return User.builder()
                .email(userInDTO.getEmail())
                .password(userInDTO.getPassword())
                .name(userInDTO.getName())
                .nickName(userInDTO.getNickName())
                .phoneNumber(userInDTO.getPhoneNumber())
                .profileImg(userInDTO.getProfileImg())
                .shortDescription(userInDTO.getShortDescription())
                .bankName(userInDTO.getBankName())
                .accountNumber(userInDTO.getAccountNumber())
                .accountHolder(userInDTO.getAccountHolder())
                .corporationName(userInDTO.getCorporationName())
                .corporationTel(userInDTO.getCorporationTel())
                .BSN(userInDTO.getBSN())
                .build();
    }
}
