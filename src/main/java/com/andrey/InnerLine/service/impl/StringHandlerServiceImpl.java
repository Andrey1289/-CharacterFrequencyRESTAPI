package com.andrey.InnerLine.service.impl;

import com.andrey.InnerLine.service.StringHandlerService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class StringHandlerServiceImpl implements StringHandlerService {


    @Override
    public Map<Character, Long> calculateCharacterFrequency(String input) {
        return input.chars() // Создаем IntStream из символов строки
                .mapToObj(c -> (char) c) // Преобразуем IntStream в Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Группируем и подсчитываем частоту
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed()) // Сортируем по убыванию частоты
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new)); // Собираем результат в LinkedHashMap для сохранения порядка
    }
}
