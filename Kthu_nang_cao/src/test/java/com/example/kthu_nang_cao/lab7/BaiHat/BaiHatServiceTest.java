package com.example.kthu_nang_cao.lab7.BaiHat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaiHatServiceTest {
    BaiHatService baiHatService = new BaiHatService();

    @BeforeEach
    void setUp() {
        BaiHatService baiHatService = new BaiHatService();
    }

    @Test
    void themBaiHat() {

    }

    @Test
    void testThemBaiHat() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        assertTrue(baiHatService.getDanhSachBaiHat().contains(baiHat));
    }

    @Test
    void testThemBaiHat1() {
        BaiHat baiHat = new BaiHat("2", "", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        assertFalse(baiHatService.getDanhSachBaiHat().contains(baiHat));
    }

    @Test
    void testThemBaiHat2() {
        BaiHat baiHat = new BaiHat("", "manhhh", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        assertFalse(baiHatService.getDanhSachBaiHat().contains(baiHat));
    }

    @Test
    void testThemBaiHat3() {
        BaiHat baiHat = new BaiHat("1", "manhhh", "Manh", 1800000, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        assertFalse(baiHatService.getDanhSachBaiHat().contains(baiHat));
    }

    @Test
    void testThemBaiHat4() {
        BaiHat baiHat = new BaiHat("1", "manhhh", "Manh", 180, "");
        baiHatService.themBaiHat(baiHat);
        assertFalse(baiHatService.getDanhSachBaiHat().contains(baiHat));
    }

    @Test
    void xoa() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        List<BaiHat> dsBaiHat = baiHatService.getDanhSachBaiHat();
        assertEquals(0, dsBaiHat.size());
    }

    @Test
    void xoaBaiHat() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
        BaiHat baiHat1 = new BaiHat("2", "Bai Hat 2", "Manhdd", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        baiHatService.xoaBaiHat(baiHat1);
        List<BaiHat> dsBaiHat = baiHatService.getDanhSachBaiHat();
        assertFalse(dsBaiHat.contains(baiHat));
    }

    @Test
    void xoa1() {
        BaiHat baiHat  = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        baiHatService.xoaBaiHat(baiHat);
        assertEquals(0, baiHatService.getDanhSachBaiHat().size());
    }
    @Test
    void xoarong() {
        BaiHat baiHat  = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat);
        BaiHat baiHat1  = new BaiHat("2", "Bai Hat 1", "Manh", 180, "Manhdz");
        baiHatService.themBaiHat(baiHat1);
        baiHatService.xoaBaiHat(baiHat);
        assertThrows(IllegalArgumentException.class,()-> baiHatService.getDanhSachBaiHat());
    }
//    @Test
//    void testXoaBaiHat_NonExistent() {
//        BaiHat baiHat1 = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
//        BaiHat baiHat2 = new BaiHat("1", "Bai Hat 1", "Manh", 180, "Manhdz");
//        baiHatService.themBaiHat(baiHat1);
//
//        baiHatService.xoaBaiHat(baiHat2);
//
//        List<BaiHat> danhSachBaiHat = baiHatService.getDanhSachBaiHat();
//        Assertions.assertEquals(1, danhSachBaiHat.size());
//        Assertions.assertTrue(danhSachBaiHat.contains(baiHat1));
//    }
}