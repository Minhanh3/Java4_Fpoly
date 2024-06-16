package com.example.kthu_nang_cao.lab8.P2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SachServiceTest {
    private SachService sachService = new SachService();

    @Test
    void addTrue() {
        sachService.add(new Sach("s4", "Connan", 100, "manh", 2));
        assertEquals(4, sachService.sachList.size());
    }

    @Test
    void addID5kytu() {
        sachService.add(new Sach("s4555", "Connan", 100, "manh", 2));
        assertEquals(4, sachService.sachList.size());
    }

    @Test
    void addID10kytu() {
        sachService.add(new Sach("s455555555", "Connan", 100, "manh", 2));
        assertEquals(4, sachService.sachList.size());
    }

    @Test
    void addId11kytu() {
        Sach idSai = new Sach("s41111ffffff", "Connan2", 100, "manh", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.add(idSai));
    }

    @Test
    void addTensachKytuDacBiet() {
        Sach idSai = new Sach("s4", "!@Connan2", 100, "manh", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.add(idSai));
    }@Test
    void timkiemten() {
        assertEquals(1, sachService.searchTen("Connan"));
    }

    //    @Test
//    void searchTeTacGiaTrue() {
//        assertEquals(1, sachService.searchTetg("manhdn"));
//    }
//
//    @Test
//    void searchTetgTrue1() {
//        Sach tentg = new Sach("s4", "Connan", 100, "manhdn", 2);
//        sachService.add(tentg);
//        assertEquals(2, sachService.searchTetg("manhdn"));
//    }
//
//    @Test
//    void searchTetgKhongCoTrongDs() {
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> sachService.searchTetg("manhdzzz"));
//    }
//
//    @Test
//    void searchTetgKhongCoTrongDsKyTuDacBiet() {
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> sachService.searchTetg("manhdn@@"));
//    }
//
//    @Test
//    void searchTeTacGiaTrong() {
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> sachService.searchTetg(""));
//    }

}
