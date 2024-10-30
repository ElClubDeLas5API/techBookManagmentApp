package org.TBMA;

public class Book {
    private String ISBN;
    private String Titulo;
    private String Autor;

    public Book(String titulo, String autor, String ISBN) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Titulo='" + Titulo + '\n' +
                ", Autor='" + Autor + '\n' +
                ", ISBN='" + ISBN + '\n';
    }
}