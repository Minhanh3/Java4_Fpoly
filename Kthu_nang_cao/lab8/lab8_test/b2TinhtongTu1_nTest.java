package com.example.kthu_nang_cao.lab8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class b2TinhtongTu1_nTest {
    private b2TinhtongTu1_n b2TtongTu1N = new b2TinhtongTu1_n();

    @Test
    void tinhTongN() {
        assertEquals(3, b2TtongTu1N.TinhTongN(2));
    }@Test
    void tinhTongNBang50() {
        assertEquals(1275, b2TtongTu1N.TinhTongN(50));
    }@Test
    void tinhTongNBang100() {
        assertEquals(5050, b2TtongTu1N.TinhTongN(100));
    }

    @Test
    void tinhTongNbang0() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(0));
    }

    @Test
    void tinhTongNbang50() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(1000));
    }

    @Test
    void tinhTongNbang101() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(101));
    }

    @Test
    void tinhTongNbangx999990() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(999999999));
    }

    @Test
    void tinhTongNBang_1() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(-1));
    }

    @Test
    void tinhTongNBang_50() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(-50));
    }

    @Test
    void tinhTongNBang_x9999999() {
        assertThrows(IllegalArgumentException.class, () -> b2TtongTu1N.TinhTongN(-999999999));
    }

}