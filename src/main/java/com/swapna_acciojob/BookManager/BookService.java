package com.swapna_acciojob.BookManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public String addBook(Book book) {
        bookRepository.add(book);
        return "Book Added with id: " + book.getId();
    }

    public Book getBook(Integer id)throws BookIdInvalidException{
        Optional<Book>bookOptional=bookRepository.getById(id);
        if(bookOptional.isEmpty()){
            throw new BookIdInvalidException(id);
        }
        return bookOptional.get();
    }
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }
    public Book getBookByName(String name) throws BookNotFoundException {
        List<Book>books= bookRepository.getAll();
        for(Book book: books){
            if(book.getTitle().equals(name))
                return book;
        }
        throw new BookNotFoundException("Book Name Invalid");
    }

    public Book updateBookPages(Integer id, Integer pages)throws BookNotFoundException {
        Book book= getBook(id);
        book.setPages(pages);
        bookRepository.update(book);
        return book;
    }

    public String deleteBook(Integer id) {
        bookRepository.delete(id);
        return "Book Deleted With Id: " +id;
    }
}