package com.cerebra.task.chatbot.model.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ItemResponse {
    private Long id;

    private String name;

    private String category;

}
