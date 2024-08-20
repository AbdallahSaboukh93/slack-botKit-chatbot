package com.cerebra.task.chatbot.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackBot {

    // for testing purpose to check the communication is working or no
    private static final String TOKEN = "xoxb-7596320426835-7596814142226-l3w5Qz5cGyTigTSMEytVZhMg";
    private static final String CHANNEL_ID = "cerebra_task_chartbot";
    private static final String SLACK_API_URL = "https://slack.com/api/chat.postMessage";

    public static void postMessage(String message) {
        try {
            URL url = new URL(SLACK_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + TOKEN);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            String jsonPayload = "{\"channel\":\"" + CHANNEL_ID + "\",\"text\":\"" + message + "\"}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}