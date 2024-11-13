package org.TBMA;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book);

    List<Book> findAll() throws SQLException;

    Optional<Book> findByIsbn(String userISBN) throws SQLException;

    void deleteByIsbn(String userISBN) throws SQLException;
}
