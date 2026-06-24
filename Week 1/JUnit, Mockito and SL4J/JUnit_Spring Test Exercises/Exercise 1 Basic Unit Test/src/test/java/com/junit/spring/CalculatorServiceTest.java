package com.junit.spring;

import org.junit.jupiter.api.Test;
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

@SpringBootTest(classes = CalculatorServiceTest.Config.class)
public class CalculatorServiceTest {
    @org.springframework.context.annotation.Configuration
    @org.springframework.context.annotation.Import(CalculatorService.class)
    static class Config {}

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}
