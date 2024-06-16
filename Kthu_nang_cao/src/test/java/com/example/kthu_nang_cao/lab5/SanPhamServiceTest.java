package com.example.kthu_nang_cao.lab5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SanPhamServiceTest {
    private SanPhamService sanPhamService;

    @BeforeEach
    void setUp() {
        sanPhamService = new SanPhamService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testThemSanPham() {
        SanPham sanPham = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", 50);
        sanPhamService.addSp(sanPham);
        assertEquals(1, sanPhamService.dsSanPham().size());
    }

    @Test
    public void testThemSanPham1() {
        SanPham sanPham = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", 0);
        sanPhamService.addSp(sanPham);
        assertFalse(sanPhamService.dsSanPham().contains(sanPham));
    }

    @Test
    public void testThemSanPham4() {
        SanPham sanPham = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", -1111111);
        sanPhamService.addSp(sanPham);
        assertFalse(sanPhamService.dsSanPham().contains(sanPham));
    }

    @Test
    public void testThemSanPham2() {
        SanPham sanPham = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", 200);
        sanPhamService.addSp(sanPham);
        assertFalse(sanPhamService.dsSanPham().contains(sanPham));
    }
    @Test
    public void testThemSanPham3() {
        SanPham sanPham = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", 222222222);
        sanPhamService.addSp(sanPham);
        assertFalse(sanPhamService.dsSanPham().contains(sanPham));
    }
    @Test
    public void testSuaSanPhamUniqueMaSanPham() {
        // Arrange
        SanPhamService sanPhamService = new SanPhamService();
        SanPham sanPham1 = new SanPham("1", "SP001", "Áo thun", 15000, "Trắng", "M", 50);
        SanPham sanPham2 = new SanPham("2", "SP002", "Quần jean", 2000, "Đen", "L", 30);
        sanPhamService.addSp(sanPham1);
        sanPhamService.addSp(sanPham2);
        sanPhamService.editSp("1", new SanPham("1", "", "Áo thun", 15000, "Trắng", "M", 50));
        assertTrue(sanPhamService.dsSanPham().stream().anyMatch(sanPham -> sanPham.getMaSanPham().equals("SP002")));
    }

}