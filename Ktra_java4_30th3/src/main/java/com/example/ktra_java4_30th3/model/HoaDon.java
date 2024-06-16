package com.example.ktra_java4_30th3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKhachHang;

    @Column(name = "IdNV")
    private Integer idNhanVien;

    @Column(name = "NgayMuaHang")
    private String ngayMuaHang;

    @Column(name = "TrangThai")
    private Integer trangThai ;
}
