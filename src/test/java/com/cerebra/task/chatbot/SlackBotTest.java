package com.cerebra.task.chatbot;

import com.cerebra.task.chatbot.service.SlackBot;
import org.junit.jupiter.api.Test;

public class SlackBotTest {
    @Test
    public void slack_post_message_test () {
        SlackBot.postMessage("Test message  abdalalh");
    }
}
