package com.codingji.komofunding.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.codingji.komofunding.common.dto.ItemDTO;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter
public class ItemListConverter implements AttributeConverter<List<ItemDTO>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // List<ItemDTO>를 JSON 문자열로 변환
    @Override
    public String convertToDatabaseColumn(List<ItemDTO> items) {
        try {
            return (items == null) ? null : objectMapper.writeValueAsString(items);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON writing error", e);
        }
    }

    // JSON 문자열을 List<ItemDTO>로 변환
    @Override
    public List<ItemDTO> convertToEntityAttribute(String s) {
        try {
            return (s == null || s.isEmpty())
                    ? new ArrayList<>()
                    : objectMapper.readValue(s, objectMapper.getTypeFactory().constructCollectionType(List.class, ItemDTO.class));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON reading error", e);
        }
    }
}