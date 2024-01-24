package com.andrey.InnerLine;

import com.andrey.InnerLine.service.StringHandlerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class InnerLineApplicationTests {
	@Mock
	StringHandlerService service;

	@Test
	void contextLoads() {
	}
	@Test
	public void checkInputString(){
		String string = "aaabbc";
		Map<Character, Long> expectedMap = new HashMap<>();
		expectedMap.put('a', 3L);
		expectedMap.put('b', 2L);
		expectedMap.put('c', 1L);

		Mockito.when(service.calculateCharacterFrequency(string)).thenReturn(expectedMap);

		Map<Character, Long> result = service.calculateCharacterFrequency(string);

		assertEquals(3, result.get('a').intValue());
		assertEquals(2, result.get('b').intValue());
		assertEquals(1, result.get('c').intValue());

	}
}
