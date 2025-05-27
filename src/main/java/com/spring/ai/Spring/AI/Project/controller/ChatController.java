package com.spring.ai.Spring.AI.Project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.openai.OpenAiChatClient;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final OpenAiChatClient chatClient;

    public ChatController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
        String question = body.get("message");
        String answer = chatClient.call(question);
        return ResponseEntity.ok(answer);
    }
}
