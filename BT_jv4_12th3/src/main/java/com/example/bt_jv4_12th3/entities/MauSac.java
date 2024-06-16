package com.example.bt_jv4_12th3.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id ;

    @Column(name = "Ma")
    private String ma ;

    @Column(name = "Ten")
    private String ten ;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
