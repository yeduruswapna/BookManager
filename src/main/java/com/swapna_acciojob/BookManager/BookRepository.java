package com.swapna_acciojob.BookManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class BookRepository {
    private Map<Integer,Book> bookData= new HashMap<>();

    public void add(Book book){

        bookData.put(book.getId(), book);
    }

    public Optional<Book> getById(Integer id) {
        if(bookData.containsKey(id)){
            Book booktoReturn= bookData.get(id);
            return Optional.of(booktoReturn);
        }
        return Optional.empty();
    }
    public List<Book> getAll() {
        return  new ArrayList<>(bookData.values());
    }

    public void update(Book book) {
        bookData.put(book.getId(), book);
    }

    public void delete(Integer id) {
        bookData.remove(id);
    }
}