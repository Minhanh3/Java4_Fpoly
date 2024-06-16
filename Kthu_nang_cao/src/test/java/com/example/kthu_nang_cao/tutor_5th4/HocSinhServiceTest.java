package com.example.kthu_nang_cao.tutor_5th4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HocSinhServiceTest {
    // Tao doi tuong Hocsinhservice
    // List
    private HocSinhService hocSinhService = new HocSinhService();
    private List<HocSinh> hocSinhList = hocSinhService.getAll();

    @Test
    // Them thanh cong
    public void addSucces() {
        //Ket qua mong muon exp
        int exp = 4; // hoc sinh fake co 3 hs , them 1 la 4
        HocSinh hocSinh = new HocSinh(4, "Thu", "Ha", 19, 2);
        hocSinhService.add(hocSinh);
        // ket qua thuc te act
        int act = hocSinhList.size(); // kiem tra laij kich thuoc cua danh sach la bao nhieu???
        // mong muon la 4size , thuc te 4 ( exp , act )
        Assertions.assertEquals(exp, act);
    }

//    @Test
//    public void addCapLever1() {
//        int exp = 4;
//        HocSinh hocSinh = new HocSinh(4, "Thu", "Ha", 19, 1);
//        hocSinhService.add(hocSinh);
//        int act = hocSinhList.size();
//        Assertions.assertEquals(exp, act);
//    }

    @Test
    public void addCapLever3() {
        int exp = 4;
        HocSinh hocSinh = new HocSinh(4, "Thu", "Ha", 19, 3);
        hocSinhService.add(hocSinh);
        int act = hocSinhList.size();
        Assertions.assertEquals(exp, act);
    }

    //    @Test
//    public void addSaiCap1() {
//        HocSinh hocSinhSaiCap = new HocSinh(4, "Thu", "Ha@", 19, 2);
//        Assertions.assertThrows(IllegalArgumentException.class, () -> hocSinhService.add(hocSinhSaiCap));
//    }
    @Test
    public void addSaiCap() {
        HocSinh hocSinhSaiCap = new HocSinh(4, "Thu", "Ha", 19, -1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> hocSinhService.add(hocSinhSaiCap));
    }

    @Test
    public void addSaiCapLa4() {
        HocSinh hocSinhSaiCap = new HocSinh(4, "Thu", "Ha", 19, 4);
        Assertions.assertThrows(IllegalArgumentException.class, () -> hocSinhService.add(hocSinhSaiCap));
    }

    // Can bien ve nha viet
    // tim kiem hoc sinh voi ten ky tu dac biet
    @Test
    public void searchKytu() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> hocSinhService.searchBylastName("Manh@"));
    }

    // tim kiem trong
    @Test
    public void searchTrong() {
        Assertions.assertThrows(NullPointerException.class, () -> hocSinhService.searchBylastName(""));
    }

    @Test
    public void searchKhongtrogDS() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> hocSinhService.searchBylastName("Phuc"));
    }

}