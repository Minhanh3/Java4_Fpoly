package com.example.luyentap1.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GiangVien {
    private int id;

    private String maGV;

    private String tenGV;

    private Integer tuoi;

    private boolean gioiTinh;

    private String diaChi;
}
