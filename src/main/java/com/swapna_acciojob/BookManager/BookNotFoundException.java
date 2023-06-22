package com.swapna_acciojob.BookManager;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String string) {
        super("Book Not Present");
    }
}
