package com.example.kthu_nang_cao.lab8;

public class b2TinhtongTu1_n {
    /*
    Sử dụng các kỹ thuật biên, kỹ thuật biên viết 10 test case để thực hiện chức năng
    tính tổng từ 1 - n  với n là giá bị bất kỳ. Kiểm tra ngoại lệ khi nhập một số giá trị
    n không phải là số dương?
    n = 2 thì i < n
    0 + 0 rồi i++ rồi 0 +1 vẫn nhỏ hơn n nên i++ 2 + 0
     */
    public int TinhTongN(int n){
        if (n <= 0){
            throw new IllegalArgumentException("N khong được nhỏ hơn or Bằng 0");
        }if (n > 100){
            throw new IllegalArgumentException("N khong được lớn hơn 100");
        }
        if (n == Integer.MAX_VALUE){
            throw new ArithmeticException("N quá giới hạn nhập ");
        }

        int sum = 0 ;
        for (int i = 0; i <=n ; i++) {
            sum += i;
        }
        return sum;
    }
}
