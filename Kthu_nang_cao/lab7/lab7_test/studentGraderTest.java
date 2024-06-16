package com.example.kthu_nang_cao.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentGraderTest {

    @Test
    void getGradeF() {
        String grade = studentGrader.getGrade(30);
        Assertions.assertEquals("F", grade);
    }

    @Test
    void getGradeD() {
        assertEquals("C", studentGrader.getGrade(60));
    }

    @Test
    void getGradeC() {
        assertEquals("D", studentGrader.getGrade(40));
    }

    @Test
    void getGradeB() {
        assertEquals("B", studentGrader.getGrade(70));
    }

    @Test
    void getGradeA() {
        assertEquals("A", studentGrader.getGrade(90));
    }

    @Test
    void getGradeThrow() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentGrader.getGrade(9999));
    }

    @Test
    void getGradeThrowA() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentGrader.getGrade(-99999));
    }
}