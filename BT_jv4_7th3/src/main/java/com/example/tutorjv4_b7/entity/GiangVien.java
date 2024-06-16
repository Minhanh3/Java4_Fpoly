package com.example.tutorjv4_b7.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity //bất cứ class nào trong entity đều là thực thể
@Table(name = "giang_vien")
@ToString
public class GiangVien {
    //J3 jdbc => truy vấn sql
    // J4: Hibernate => truy vấn dựa HQL(Hibernate Quẻy Lânggue)
    // => truy vấn vao các class trong entity( thực thể )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "mssv")
    private String mssv ;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "tuoi")
    private Long tuoi ;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh ;

    @Column(name = "que_quan")
    private String queQuan ;

}
