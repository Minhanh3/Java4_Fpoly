package com.example.tech_20th12.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
}
