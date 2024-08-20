package com.cerebra.task.chatbot.repository;

import com.cerebra.task.chatbot.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<ItemEntity,Long> {
}
