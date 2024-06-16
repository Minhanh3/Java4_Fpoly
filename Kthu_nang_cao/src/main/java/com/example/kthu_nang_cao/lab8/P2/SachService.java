package com.example.kthu_nang_cao.lab8.P2;

import java.util.ArrayList;
import java.util.List;

public class SachService {

    List<Sach> sachList = new ArrayList<>();

    public SachService() {
        sachList.add(new Sach("s1", "Connan", 100, "manh", 2));
        sachList.add(new Sach("s2", "Dore", 100, "manhdZ", 3));
        sachList.add(new Sach("s3", "KickBo", 100, "manhdn", 1));
    }

    public void add(Sach sach) {
        String validate = ".*[a-zA-Z0-9].*";
        String regexName = "^[a-zA-Z\\p{L}\\s]{0,50}$";
        if (sach.getId().length() > 10) {
            throw new IllegalArgumentException("id kh được tren 10 ký tự");
        } else if (sach.getId().isBlank() || sach.getId() == "") {
            throw new IllegalArgumentException("id lỗi ");
        } else if (!sach.getTen().matches(regexName)) {
            throw new IllegalArgumentException("tên không được chưa ký tự đặc biệt");
        }
        sachList.add(sach);
    }
    // co ngân
    public int searchTen(String ten) {
        int count = 0;
        for (Sach sach : sachList) {
            String n = sach.getTen();
            if (n.equals(ten)) {
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("khong hop le");
        } else {
            return count;
        }
    }
}
