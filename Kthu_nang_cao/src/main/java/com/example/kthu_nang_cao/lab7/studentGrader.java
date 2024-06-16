package com.example.kthu_nang_cao.lab7;

public class studentGrader {
    public static String getGrade(int score) throws IllegalArgumentException {
        if (score < 0 || score > 100){
            throw new IllegalArgumentException("Diem so khong duoc duoi 0 va tren 100");
        }
        if (score <  40) {
            return "F";
        } else if (score < 60) {
            return "D";
        } else if (score < 70) {
            return "C";
        } else if (score < 80) {
            return "B";
        } else {
            return "A";
        }
    }
}
