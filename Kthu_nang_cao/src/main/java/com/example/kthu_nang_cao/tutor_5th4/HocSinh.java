package com.example.kthu_nang_cao.tutor_5th4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HocSinh {
    private int studentID;
    private String firstName ;
    private String lastName ;
    private int age ;
    private int gradeLevel ;
}
