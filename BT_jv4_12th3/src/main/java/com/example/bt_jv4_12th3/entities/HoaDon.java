package com.example.bt_jv4_12th3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id ;

    @Column(name = "IdNV")
    private Integer idNhanVien;

    @Column(name = "IdKH")
    private Integer idKhachHang ;

    @Column(name = "NgayMuaHang")
    private String ngayMuaHang;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
