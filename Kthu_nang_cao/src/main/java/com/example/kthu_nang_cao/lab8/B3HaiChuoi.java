package com.example.kthu_nang_cao.lab8;

public class B3HaiChuoi {
    /*
    Hãy viết một lớp StringManipulator chứa phương thức concatenate(String str1, String str2)
    để nối hai chuỗi lại với nhau. Tuy nhiên, phương thức này có thể nhận được tham số null.
    Hãy viết các unit test sử dụng framework JUnit/NUnit để đảm bảo rằng phương thức concatenate()
    xử lý đúng các trường hợp này và ném ngoại lệ NullPointerException/NullReferenceException
    khi nhận tham số null.
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("Khong the null");
        }
        return str1 + str2;
    }
}
