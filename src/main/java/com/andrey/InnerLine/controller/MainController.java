package com.andrey.InnerLine.controller;

import com.andrey.InnerLine.service.StringHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
    @RequestMapping("/api/v1/strings")
public class MainController {
    private final StringHandlerService service;
    @Autowired
    public MainController(StringHandlerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Map<Character, Long> calculateFrequency(@RequestBody Map<String, String> request) {
        String input = request.get("string");
        Map<Character, Long> characterLongMap = service.calculateCharacterFrequency(input);
        System.out.println(characterLongMap);
        return characterLongMap;
    }
}
