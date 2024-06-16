package com.example.kthu_nang_cao.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bai1Test {
    bai1 bai1 = new bai1();

    @Test
    void chia() {
        assertEquals(bai1.chia(9, 3), 3);
    }

    @Test
    void chia2() {
        assertEquals(bai1.chia(1000, 2), 500);
    }

    @Test
    void chia3() {
        assertEquals(bai1.chia(100, 100), 1);
    }

    @Test
    void chia4() {
        assertEquals(bai1.chia(100, -10), -10);
    }

    @Test
    void chia5() {
        assertEquals(bai1.chia(100, 999999), 0);
    }



}