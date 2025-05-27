package com.spring.ai.Spring.AI.Project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
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

    // 1. Generate Image from Text Prompt
    @PostMapping("/image/generate")
    public String generateImage(@RequestBody Map<String, String> body) {
        String prompt = body.get("prompt");
        // Placeholder response
        return "[Mocked] Generated image for prompt: " + prompt;
    }

    // 2. Describe Uploaded Image
    @PostMapping("/image/describe")
    public String describeImage(@RequestParam("file") MultipartFile file) {
        // Placeholder response
        return "[Mocked] Description of uploaded image: " + file.getOriginalFilename();
    }

    // 3. Summarize YouTube Video
    @PostMapping("/video/summarize")
    public String summarizeVideo(@RequestBody Map<String, String> body) {
        String url = body.get("url");
        // Placeholder response
        return "[Mocked] Summary of video at URL: " + url;
    }

    // 4. Code Review
    @PostMapping("/chat/code-review")
    public String codeReview(@RequestBody Map<String, String> body) {
        String code = body.get("code");
        return chatClient.call("Please review the following Java code:\n" + code);
    }

    // 5. Interview Q&A
    @GetMapping("/chat/interview-qa")
    public List<String> interviewQA(@RequestParam String topic) {
        String prompt = "Give me 3 interview questions with answers about: " + topic;
        String response = chatClient.call(prompt);
        return List.of(response.split("\n\n"));
    }
}
