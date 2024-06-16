package com.example.bt_jv4_12th3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id ;

    @Column(name = "IdHoaDon")
    private Integer idHoaDon ;

    @Column(name = "IdSPCT")
    private Integer idSPCT;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Integer donGia;

    @Column(name = "ThoiGian")
    private Date thoiGian;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
