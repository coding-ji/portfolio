package com.codingji.komofunding.common.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// 프로젝트 상세 상품
public record ItemDTO(
        @NotNull(message = "아이템 이름은 필수 입력입니다.")
        @Size(max = 100, message = "아이템 이름은 최대 100자까지 입력할 수 있습니다.")
        String itemName,

        @NotNull(message = "아이템 가격은 필수 입력입니다.")
        @Min(value = 1, message = "아이템 가격은 최소 1원 이상이어야 합니다.")
        Long itemPrice,

        @NotNull(message = "아이템 수량은 필수 입력입니다.")
        @Min(value = 1, message = "아이템 수량은 최소 1개 이상이어야 합니다.")
        Long itemAmount
) {
}
