package org.TBMA;

import java.util.ArrayList;
import java.util.Objects;

public class BookManager {
    private ArrayList<Book> getRepoBooks1 = new ArrayList<Book>();

    public BookManager() {
    }

    public void addBook(BookConsoleView application) {
        Book newBook = application.getBookData(2);
        int inListIndex = this.isBookInList(newBook.getISBN());
        String isbnNewBook = newBook.getISBN();

        if (inListIndex >= 0) {
            System.out.println("El libro ya existe en la lista.");
            return;
        }

        getRepoBooks1.add(newBook);
        System.out.println("Libro añadido con éxito.");

    }

    public void deleteBook(BookConsoleView application) {
        Book deleteISBN = application.getBookData(3);
        int index = this.isBookInList(deleteISBN.getISBN());
        String isbnDeleteBook = deleteISBN.getISBN();

        if (index == -1) {
            System.out.println("El ISBN introducido no existe.");
            return;
        }

        getRepoBooks1.remove(index);
        System.out.println("Libro eliminado con éxito.");
    }

    public int isBookInList(String uISBN) {
        for (Book book : getRepoBooks1) {
            String getterIsbn = book.getISBN();
            if ((Objects.equals(uISBN, getterIsbn))) {
                return getRepoBooks1.indexOf(book);
            }
        }
        return -1;
    }

    public ArrayList<Book> getGetRepoBooks1() {
        return this.getRepoBooks1;
    }
}