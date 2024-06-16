package com.example.kthu_nang_cao.lab8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class B3HaiChuoiTest {
    private B3HaiChuoi b3HaiChuoi = new B3HaiChuoi();

    @Test
    void concatenate() {
        assertEquals("manh", b3HaiChuoi.concatenate("ma", "nh"));
    }

    @Test
    void concatenateNull1() {
        assertThrows(NullPointerException.class, () -> b3HaiChuoi.concatenate(null, "manh"));
    }

    @Test
    void concatenateNull2() {
        assertThrows(NullPointerException.class, () -> b3HaiChuoi.concatenate("Manh", null));
    }

    @Test
    void concatenateNullCa2() {
        assertThrows(NullPointerException.class, () -> b3HaiChuoi.concatenate(null, null));
    }
}