package com.example.kthu_nang_cao.lab7.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private List<BaiHat> danhSachBaiHat;

    public BaiHatService() {
        danhSachBaiHat = new ArrayList<>();
    }

    public void themBaiHat(BaiHat baiHat) {
        if (baiHat.getTenCaSi() == null && baiHat.getTen() == null && baiHat.getId() == null && baiHat.getDoDai() > 1000 && baiHat.getTenNhacSi() == null) {
            System.out.println("Lỗi");
            danhSachBaiHat.add(baiHat);
        }
    }

    public void xoaBaiHat(BaiHat baiHat) {
        danhSachBaiHat.remove(baiHat);
    }

    public List<BaiHat> getDanhSachBaiHat() {
        return danhSachBaiHat;
    }
}
