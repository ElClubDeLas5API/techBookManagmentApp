package org.TBMA;

public class Book {

    private String isbn;
    private String title;
    private String author;

    public Book(String titulo, String autor, String ISBN) {
        this.title = titulo;
        this.author = autor;
        this.isbn = ISBN;
    }

    @Override
    public String toString() {
        return "Titulo: " + title + '\n' +
                "Autor: " + author + '\n' +
                "ISBN: " + isbn;
    }

    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }

    public Object getAuthor() {
        return author;
    }
}