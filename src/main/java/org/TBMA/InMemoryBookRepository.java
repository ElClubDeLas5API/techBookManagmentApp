package org.TBMA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private static List<Book> booksDB = new ArrayList<>();

    @Override
    public void save(Book book) {
        booksDB.add(book);

    }

    @Override
    public List<Book> findAll() {
        return booksDB;
    }

    @Override
    public Optional<Book> findByIsbn(String userISBN) {
        //buscarlo
        //si esta devolverlo como optional
        //sino esta un optional empty
        return Optional.empty();
    }

    @Override
    public void deleteByIsbn(String userISBN) {
        booksDB.removeIf(book -> book.getIsbn().equals(userISBN));
    }
}
