package org.TBMA;

import java.util.ArrayList;
import java.util.Objects;

public class BookManager {
    private ArrayList<Book> getRepoBooks1 = new ArrayList<>();

    public BookManager() {
    }

    public void addBook(Book newBook) {
        int inListIndex = this.isBookInList(newBook.getIsbn());
        String isbnNewBook = newBook.getIsbn();

        if (inListIndex >= 0 && isbnNewBook.isEmpty()) {
            throw new IllegalArgumentException("El libro ya existe en la lista.");
        }

        getRepoBooks1.add(newBook);

    }

    public void deleteBook(String isbnDeleteBook) {
        int index = this.isBookInList(isbnDeleteBook);

        if (index == -1) {
            throw new IllegalArgumentException("El ISBN introducido no existe.");
        }

        getRepoBooks1.remove(index);
    }

    public int isBookInList(String uISBN) {
        for (Book book : getRepoBooks1) {
            String getterIsbn = book.getIsbn();
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