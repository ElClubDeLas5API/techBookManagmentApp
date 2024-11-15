package org.TBMA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBookRepository implements BookRepository {
    @Override
    public void save(Book book) {
        //     String sql = "INSERT INTO books (isbn, title, author) VALUES ('%s', '%s', '%s')".formatted(book.getIsbn(), book.getTitle(), book.getAuthor());
        String sql = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";


        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        List<Book> bookList = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                String title = res.getString("title");
                String author = res.getString("author");
                String isbn = res.getString("isbn");

                Book book = new Book(title, author, isbn);
                bookList.add(book);
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return bookList;
    }

    @Override
    public Optional<Book> findByIsbn(String userISBN) {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        Book book = null;


        try {
            Connection connection = MySQLConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userISBN);

            ResultSet res = statement.executeQuery();

            if (res.next()) {

                String title = res.getNString("title");
                String author = res.getNString("author");
                String isbn = res.getNString("isbn");

                book = new Book(title, author, isbn);
                return Optional.of(book);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();


    }

    @Override
    public void deleteByIsbn(String userISBN) {
        String sql = "DELETE FROM books WHERE isbn = ?";

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, userISBN);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
