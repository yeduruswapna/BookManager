package com.swapna_acciojob.BookManager;

public class BookIdInvalidException extends RuntimeException {
    public BookIdInvalidException(Integer id) {
        super("Boook Not Present with id: " + id);
    }
}
