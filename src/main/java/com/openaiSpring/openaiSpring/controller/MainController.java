package com.openaiSpring.openaiSpring.controller;

import com.openaiSpring.openaiSpring.model.ChatCompletionRequest;
import com.openaiSpring.openaiSpring.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/hitOpenaiApi")
    public String getOpenaiResponse(@RequestBody String prompt) {

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo", prompt);

        ChatCompletionResponse chatCompletionResponse = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest, ChatCompletionResponse.class);
              return chatCompletionResponse.getChoices().get(0).getMessage().getContent();
    }
}
