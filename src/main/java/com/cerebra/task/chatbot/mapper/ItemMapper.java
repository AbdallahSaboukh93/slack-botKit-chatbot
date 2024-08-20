package com.cerebra.task.chatbot.mapper;

import com.cerebra.task.chatbot.entity.ItemEntity;
import com.cerebra.task.chatbot.model.request.ItemRequest;
import com.cerebra.task.chatbot.model.response.ItemResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

// Will use map Struct if  have time
    public static ItemResponse toItemResponse(ItemEntity item) {
        return ItemResponse.builder().id(item.getId()).category(item.getCategory()).name(item.getName()).build();
    }

    // Method to convert a list of Item entities to a list of ItemResponses
    public static List<ItemResponse> toItemResponseList(List<ItemEntity> Items) {
        return Items.stream()
                .map(ItemMapper::toItemResponse)
                .collect(Collectors.toList());
    }

    public static ItemEntity toItemEntity(ItemRequest itemRequest) {
        return ItemEntity.builder().category(itemRequest.getCategory()).name(itemRequest.getName()).build();
    }
}
