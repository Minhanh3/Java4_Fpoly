package com.example.bt_jv4_12th3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id ;

    @Column(name = "MaSPCT")
    private String maSPCT ;

    @Column(name = "IdKichThuoc")
    private Integer idKichThuoc;

    @Column(name = "IdMauSac")
    private Integer idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdSanPham" , referencedColumnName = "id")
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
