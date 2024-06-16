package com.example.kthu_nang_cao.lab2;

public class TestGiaithua {
    public static void main(String[] args) {
        int number = 10 ;
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Giai thừa của " + number + " là: " + fact);
        System.out.println();
    }
}
