package com.junit.spring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}

@SpringBootTest(classes = CalculatorParameterizedTest.Config.class)
public class CalculatorParameterizedTest {
    @org.springframework.context.annotation.Configuration
    @org.springframework.context.annotation.Import(CalculatorService.class)
    static class Config {}

    @Autowired
    private CalculatorService calculatorService;

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10",
        "10, -2, 8",
        "0, 0, 0"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
