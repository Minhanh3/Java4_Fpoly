package com.example.kthu_nang_cao.lab5;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> lists = new ArrayList<>();

    public void addSp(SanPham sp){

        if (sp.getSoLuong() > 0 && sp.getSoLuong() < 100){
            lists.add(sp);
            System.out.println("Them thanh cong");
        }else {
            System.out.println("So luong phai la so duong va nho hon 100");
        }
    }
    public void editSp(String id , SanPham spnew){
        for (int i = 0; i < lists.size(); i++) {
            SanPham sp = lists.get(i);
            if (sp.getId().equals(id)) {
                lists.set(i , spnew);
                return;
            }
        }
    }
    public void deleteSp(String id){
        lists.removeIf(sanPham -> sanPham.getId().equals(id));
    }
    public List<SanPham> dsSanPham(){
        return lists;
    }
}
