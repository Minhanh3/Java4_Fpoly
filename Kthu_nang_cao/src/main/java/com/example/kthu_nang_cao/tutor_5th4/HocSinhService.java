package com.example.kthu_nang_cao.tutor_5th4;

import java.util.ArrayList;
import java.util.List;

public class HocSinhService {
    List<HocSinh> hocSinhList = new ArrayList<>();

    public HocSinhService() {
        hocSinhList.add(new HocSinh(1, "Duc", "Manh", 18, 3));
        hocSinhList.add(new HocSinh(2, "Duc", "Anh", 17, 2));
        hocSinhList.add(new HocSinh(3, "Ha", "Hoa", 16, 1));
    }

    //chuc nang them
    public void add(HocSinh hocSinh) {
        //Check cap do : cap 1 , 2 , 3 , 4
        if (hocSinh.getGradeLevel() <= 1 || hocSinh.getGradeLevel() > 3) {
            //nem ngoai le
            throw new IllegalArgumentException("Cấp học của học sinh chỉ từ 1 -> 3");
        } else {
            hocSinhList.add(hocSinh);
        }
    }

    // tao class validate trống , ký tự đặc biệt
    public boolean validate(String inputSearch) {
        if (inputSearch.trim().isEmpty()) {
            // check trống
            throw new NullPointerException("LastName khong duoc trong");
        } else {
            // ký tự đặc biệt
            if (!inputSearch.matches(".*[a-zA-Z0-9].*")) {
                throw new IllegalArgumentException("Khong chua ky Tu Dac Biet");
            }
        }
        return true;
    }

    // tim kiem
    public int searchBylastName(String lastName) {
        int count = 0;
        if (validate(lastName)) {
            for (HocSinh hocSinh : hocSinhList) {
                String lastNameHs = hocSinh.getLastName();
                if (lastNameHs.equalsIgnoreCase(lastName)) {
                    count++;
                }
            }
            //neu tim thay ten dem thi count++ , ngc lai thi nem ra ngoai le ( khong trong list )
            if (count == 0) {
                throw new ArrayIndexOutOfBoundsException("Khong co ten dem trong danh sach");
            } else {
                return count;
            }
        }
        return 0;
    }

    public List<HocSinh> getAll() {
        return hocSinhList;
    }
}
