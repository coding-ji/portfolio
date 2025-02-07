package com.codingji.komofunding.common.dto;

// 프로젝트 상세 상품
public record ItemDTO(
       String itemName,
       Long itemPrice,
       Long itemAmount
) {
}
