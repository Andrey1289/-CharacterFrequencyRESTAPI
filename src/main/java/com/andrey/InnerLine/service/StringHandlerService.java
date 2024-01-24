package com.andrey.InnerLine.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface StringHandlerService {
    public Map<Character, Long> calculateCharacterFrequency(String string);
}
