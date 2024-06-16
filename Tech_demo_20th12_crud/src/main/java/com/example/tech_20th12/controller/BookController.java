package com.example.tech_20th12.controller;

import com.example.tech_20th12.dto.BookRequest;
import com.example.tech_20th12.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("ox-12", new Book("ox-12", "manh kin", "manh", 2000));
        books.put("ox-13", new Book("ox-13", "manh ken", "manh", 3000));

    }

    @GetMapping("")
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newbook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newbook);
        return newbook;
    }

    @GetMapping("/{id}")
    public Book getBookId(@PathVariable String id) {
        return books.get(id);
    }

    @PutMapping("/{id}")
    public Book updateBookId(@PathVariable String id, @RequestBody BookRequest bookRequest) {
        Book updatebook = new Book(id, bookRequest.title(), bookRequest.author(), bookRequest.year());
//        books.put(id, updatebook);
        books.replace(id,updatebook);
        return updatebook;
    }

    @DeleteMapping("/{id}")
    public Book deleteBookId(@PathVariable String id) {
        Book removebook = books.remove(id);
        return removebook;
    }
}



