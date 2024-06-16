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
            throw new IllegalArgumentException("Sai");
        }else {
            danhSachBaiHat.add(baiHat);
        }
    }

    public void xoaBaiHat(BaiHat baiHat) {
        if (baiHat == null){
            throw new IllegalArgumentException("loi");
        }
        danhSachBaiHat.remove(baiHat);
    }

    public List<BaiHat> getDanhSachBaiHat() {
        return danhSachBaiHat;
    }
}
