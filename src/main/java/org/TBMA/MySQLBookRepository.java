package org.TBMA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBookRepository implements BookRepository {
    @Override
    public void save(Book book) {
        String sql = "INSERT INTO books (isbn, title, author) VALUES ('%s', '%s', '%s')".formatted(book.getIsbn(), book.getTitle(), book.getAuthor());


        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Book> findAll() throws SQLException {
        String sql = "SELECT * FROM books";
        List<Book> bookList = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                String title = res.getNString("title");
                String author = res.getNString("author");
                String isbn = res.getNString("isbn");

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
    public Optional <Book> findByIsbn(String userISBN) throws SQLException {
        String sql = "SELECT * FROM books WHERE isbn = '%s'" .formatted(userISBN);
        Book book = null;


        try{
            Connection connection = MySQLConnection.getConnection();

            Statement statement1= connection.createStatement();
            ResultSet res = statement1.executeQuery(sql);

             if (res.next()){

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
    public void deleteByIsbn(String userISBN) throws SQLException{
        String sql = "DELETE FROM books WHERE isbn = '%s'" .formatted(userISBN);
        Book book = null;

        try{
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return;
    }
}
