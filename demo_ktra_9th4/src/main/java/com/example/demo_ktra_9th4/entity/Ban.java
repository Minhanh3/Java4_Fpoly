package com.example.demo_ktra_9th4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ban")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SoThich")
    private String soThich;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

//    @Column(name = "IdMQH")
//    private Integer idMqh;

//    @Column(name = "TrangThai")
//    private Integer trangThai;

}
