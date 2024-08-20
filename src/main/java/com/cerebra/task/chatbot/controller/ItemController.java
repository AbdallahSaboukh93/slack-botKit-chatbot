package com.cerebra.task.chatbot.controller;

import com.cerebra.task.chatbot.model.request.ItemRequest;
import com.cerebra.task.chatbot.model.response.ItemResponse;
import com.cerebra.task.chatbot.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Operation(summary = "Get all items", description = "Retrieve a list of all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of items"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<ItemResponse>> getItems() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }


    @Operation(summary = "Create new item", description = "Create a new item in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input provided"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@Valid @RequestBody ItemRequest item) {
        ItemResponse createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }
}
