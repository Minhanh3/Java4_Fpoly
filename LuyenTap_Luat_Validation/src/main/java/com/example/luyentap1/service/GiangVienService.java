package com.example.luyentap1.service;

import com.example.luyentap1.model.GiangVien;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class GiangVienService {
    List<GiangVien> list = new ArrayList<>();

    public GiangVienService() {
        list.add(new GiangVien(1, "GV1", "Luat", 19, false, "HN"));
        list.add(new GiangVien(2, "GV2", "Luat", 19, true, "HN"));
        list.add(new GiangVien(3, "GV3", "Luat", 19, false, "HCM"));
        list.add(new GiangVien(4, "GV4", "Luat", 19, true, "HN"));
        list.add(new GiangVien(5, "GV5", "Luat", 19, false, "HN"));
    }

    public void delete(String ma) {
        for (GiangVien x : list
        ) {
            if (x.getMaGV().equalsIgnoreCase(ma)) {
                list.remove(x);
                return;
            }
        }
    }

    public Map<String, String> sua(String ma, GiangVien giangVien) {
        Map<String, String> errors = new HashMap<>();
        if (giangVien.getMaGV().isEmpty() || giangVien.equals("")) {
            errors.put("ma", "Mã không được trông");
        }
        if (giangVien.getTenGV().isEmpty() || giangVien.equals("")) {
            errors.put("ten", "Ten không được trông");
        }
        if (giangVien.getTuoi() == null || giangVien.getTuoi() == 0 || giangVien.equals("")) {
            errors.put("tuoi", "tuoi không được trông");
        } else {
            if (!(giangVien.getTuoi() > 0 && giangVien.getTuoi() < 100)) {
                errors.put("tuoi", "tuoi phai <100 va lon hon 0");
            }
        }
        if (giangVien.getDiaChi().isEmpty() || giangVien.equals("")) {
            errors.put("diaChi", "dia chi không được trông");
        }
        if (errors.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                GiangVien g = list.get(i);
                if (g.getMaGV().toLowerCase().contains(ma.toLowerCase())) {
                    list.set(i, giangVien);
                    return null;
                }
            }
            return null;
        }
        return errors;
    }

    public List<GiangVien> search(String ten, Boolean gioiTinh) {
        List<GiangVien> newList = new ArrayList<>();
        for (GiangVien x : list
        ) {
            if (x.getTenGV().toLowerCase().contains(ten.toLowerCase()) && x.isGioiTinh() == gioiTinh) {
                newList.add(x);
            }
        }
        return newList;
    }

    public Map<String, String> them(GiangVien giangVien) {
        Map<String, String> errors = new HashMap<>();
        if (giangVien.getMaGV().isEmpty() || giangVien.equals("")) {
            errors.put("ma", "Mã không được trông");
        }
        if (giangVien.getTenGV().isEmpty() || giangVien.equals("")) {
            errors.put("ten", "Ten không được trông");
        }
        if (giangVien.getTuoi() == null || giangVien.getTuoi() == 0 || giangVien.equals("")) {
            errors.put("tuoi", "tuoi không được trông");
        } else {
            if (!(giangVien.getTuoi() > 0 && giangVien.getTuoi() < 100)) {
                errors.put("tuoi", "tuoi phai <100 va lon hon 0");
            }
        }
        if (giangVien.getDiaChi().isEmpty() || giangVien.equals("")) {
            errors.put("diaChi", "dia chi không được trông");
        }
        if (errors.isEmpty()) {
            list.add(giangVien);
            return null;
        }
        return errors;
    }

    public GiangVien detail(String ma) {
        for (GiangVien x : list
        ) {
            if (x.getMaGV().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

}
