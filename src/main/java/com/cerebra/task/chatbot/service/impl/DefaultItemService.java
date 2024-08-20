package com.cerebra.task.chatbot.service.impl;

import com.cerebra.task.chatbot.entity.ItemEntity;
import com.cerebra.task.chatbot.mapper.ItemMapper;
import com.cerebra.task.chatbot.model.request.ItemRequest;
import com.cerebra.task.chatbot.model.response.ItemResponse;
import com.cerebra.task.chatbot.repository.ItemRepository;
import com.cerebra.task.chatbot.service.ItemService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultItemService  implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemResponse> getItems() {
        return ItemMapper.toItemResponseList(itemRepository.findAll());
    }


    public ItemResponse createItem(ItemRequest itemRequest) {
        ItemEntity itemEntity = itemRepository.save(ItemMapper.toItemEntity(itemRequest));
        return   ItemMapper.toItemResponse(itemEntity);
    }
}
