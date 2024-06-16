package com.example.kthu_nang_cao.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicSplitPaneDivider;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {
    calculator calculator = new calculator();

    @Test
    void nhan() {
        assertEquals(calculator.nhan(5, 5), 25);
    }

    @Test
    void nhan2() {
        assertEquals(calculator.nhan(5, 500000000), 999999);
    }

    @Test
    void chia() {
        assertEquals(calculator.chia(100, 2), 50);
    }

    @Test
    void chia2() {
        assertEquals(calculator.chia(100, 333333), 50);
    }

    @Test
    void chia1() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.chia(99, 0);
        });
    }
//    @Test
//    void chia() {
//        Assertions.assertThrows(DivideByZeroException.class, () -> {
//            calculator.chia(9, 0);
//        });
//    }
}