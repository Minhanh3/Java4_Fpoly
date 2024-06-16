package com.example.demo_kthu16th4;

public class Bai2 {
    public  String tinhDiemTb(int a){
        if (a < 0 || a > 100) {
            throw new IllegalArgumentException("khong hop le");
        }
        if (a < 5) {
            return "Yeu";
        }else if (a < 7) {
            return "SV TB Kha";
        } else if (a < 8) {
            return "Kha";
        } else if (a < 9) {
            return "Gioi";
        }else {
            return "Xuat Sac";
        }
    }
}
