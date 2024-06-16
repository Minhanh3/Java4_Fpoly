package com.example.kthu_nang_cao.lab8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class B1TrungBinhCongTest {
    private B1TrungBinhCong b1tbc = new B1TrungBinhCong();

    @Test
    void trungBinhCongTrue() {
        assertEquals(6.0, b1tbc.trungBinhCong(6, 6, 6));
    }

    @Test
    void TinhtbcHoaAm() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(6, 6, -5));
    }

    @Test
    void TinhtbcLyAm() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(6, -6, 5));
    }

    @Test
    void TinhtbcToanAm() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(-6, 6, 5));
    }

    @Test
    void TinhtbcToan0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(0, 6, 5));
    }

    @Test
    void TinhtbcLy0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(6, 0, 5));
    }

    @Test
    void TinhtbcHoa0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(9, 6, 0));
    }

    @Test
    void TinhtbcToan0Ly0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(0, 0, 6));
    }

    @Test
    void TinhtbcLy0hoa0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(6, 0, 0));
    }

    @Test
    void TinhtbcToan0Ly0hoa0() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(0, 0, 0));
    }

    @Test
    void TinhtbcToan11Ly11hoa11() {
        assertThrows(IllegalArgumentException.class, () -> b1tbc.trungBinhCong(11, 11, 11));
    }

}