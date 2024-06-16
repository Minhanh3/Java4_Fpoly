package com.example.kthu_nang_cao.lab3_15th3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageCalculatorTest {

    @Test
    public void testAverageWithNullList() {
        List<Integer> numbers = List.of(5 , 5);
        AverageCalculator calculator = new AverageCalculator();
        double result = calculator.calculateAverage(numbers);
        assertEquals(5, result);
    }

    @Test
    public void testAverageWithNullLis1t() {
        List<Integer> numbers = null;
        AverageCalculator calculator = new AverageCalculator();
        double result = calculator.calculateAverage(numbers);
        assertEquals(5.0, result);
    }

    @Test
    public void testAverageWithLargeNumbers() {
        List<Integer> numbers = List.of(1000000, 2000000, 3000000);
        AverageCalculator calculator = new AverageCalculator();
        double result = calculator.calculateAverage(numbers);
        assertEquals(2000000, result);
    }
}