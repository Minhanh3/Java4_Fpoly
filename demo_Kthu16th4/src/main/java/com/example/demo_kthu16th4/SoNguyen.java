package com.example.demo_kthu16th4;

public class SoNguyen {
    public int soNguyen(int a){
        if (a < 0 || a > 100){
            throw new IllegalArgumentException("Khong duoc âm");
        }else {
            System.out.println("So dung");
        }
        return 1;
    }
}
