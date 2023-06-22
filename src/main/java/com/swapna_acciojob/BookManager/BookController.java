package com.swapna_acciojob.BookManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        String str= bookService.addBook(book);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }
    @GetMapping("/get-book")
    public ResponseEntity<Book> getBook(@RequestParam Integer id){
        try{
            Book book= bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (BookIdInvalidException ex){
            System.out.println("Book Not Found");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/get-book-by-name/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name) {
        try {
            Book book = bookService.getBookByName(name);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch(BookNotFoundException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-book-pages/{id}/{pages}")
    public ResponseEntity<Book> updateBookPages(@PathVariable Integer id, @PathVariable Integer pages){
        try {
            Book book = bookService.updateBookPages(id, pages);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch(BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        String str= bookService.deleteBook(id);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }


}
