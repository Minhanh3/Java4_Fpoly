package com.example.kthu_nang_cao.lab8;

import jakarta.servlet.http.PushBuilder;

public class B1TrungBinhCong {
    //    Sử dụng các kỹ thuật biên, kỹ thuật phân vùng tương đương viết 10 test case để thực hiện
//    chức năng tính trung bình cộng của điểm toán lý hoá. Kiểm tra ngoại lệ khi thực hiện phép chia cho 0
    public double trungBinhCong(int toan, int ly, int hoa) {
        if (toan < 0 || ly < 0 || hoa < 0) {
            throw new IllegalArgumentException("Lỗi không được nhỏ hơn 0");
        }else if (toan > 10 || ly > 10 || hoa > 10){
            throw new IllegalArgumentException("Lỗi không được lớn hơn 10");
        }else if (toan == 0 || ly == 0 || hoa == 0){
            throw new IllegalArgumentException("Lỗi không được = 0 ");
        }
        return (double)(toan + ly + hoa) / 3;
    }
}
