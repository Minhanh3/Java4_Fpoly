package com.example.demo_kthu16th4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai2Test {
    private Bai2 bai2 = new Bai2();

    @Test
    void tinhDiemTb() {
        assertEquals("Yeu", bai2.tinhDiemTb(4));
    }

    @Test
    void tinhDiemTb1() {
        assertEquals("Kha", bai2.tinhDiemTb(7));
    }
}