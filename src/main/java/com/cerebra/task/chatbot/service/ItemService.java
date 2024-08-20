package com.cerebra.task.chatbot.service;

import com.cerebra.task.chatbot.model.request.ItemRequest;
import com.cerebra.task.chatbot.model.response.ItemResponse;

import java.util.List;

public interface ItemService {

    List<ItemResponse> getItems();

    ItemResponse createItem(ItemRequest item);
}
