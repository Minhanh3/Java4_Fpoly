package com.example.demo_kthu16th4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoNguyenTest {
    private SoNguyen nguyen = new SoNguyen();

    @Test
    void soNguyen() {
        assertEquals(1, nguyen.soNguyen(1));
    }@Test
    void soNguyenla10() {
        assertEquals(1, nguyen.soNguyen(10));
    }@Test
    void soNguyenLa100() {
        assertEquals(1, nguyen.soNguyen(100));
    }

    @Test
    void soNguyenAm1() {
        assertThrows(IllegalArgumentException.class, () -> nguyen.soNguyen(-1));
    }

    @Test
    void soNguyenAm10() {
        assertThrows(IllegalArgumentException.class, () -> nguyen.soNguyen(-10));
    }

    @Test
    void soNguyenAm100() {
        assertThrows(IllegalArgumentException.class, () -> nguyen.soNguyen(-100));
    }@Test
    void soNguyen100() {
        assertThrows(IllegalArgumentException.class, () -> nguyen.soNguyen(101));
    }
}