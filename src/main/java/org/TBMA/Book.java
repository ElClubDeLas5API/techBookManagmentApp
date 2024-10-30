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

    public void infoBook() {
        System.out.println("Título: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("ISBN: " + ISBN + "\n");
    }

    public static void printList(Book[] arrayList) {

        if (arrayList.length == 0) {
            System.out.println("No hay libros guardados");
            return;
        }
        System.out.println("\nLista de Libros: ");
        for (Book item : arrayList) {
            item.infoBook();
        }
    }
}


