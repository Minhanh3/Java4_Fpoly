package com.example.kthu_nang_cao.lab5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    private String id ;
    private String maSanPham ;
    private String tenSanPham ;
    private float gia ;
    private String mauSac ;
    private String kichThuoc ;
    private int soLuong ;
}
