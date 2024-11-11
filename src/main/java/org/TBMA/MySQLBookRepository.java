package org.TBMA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBookRepository {
    public void save(Book book) {
        String sql = "INSERT INTO books (isbn, title, autor) VALUES ('%s', '%s', '%s')".formatted(book.getIsbn(), book.getTitle(), book.getAuthor());


        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Book> findAll() throws SQLException {
        String sql = "SELECT * FROM books";
        List<Book> bookList = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while (res.next()) {
                String title = res.getNString("title");
                String autor = res.getNString("autor");
                String isbn = res.getNString("isbn");

                Book book = new Book(title, autor, isbn);
                bookList.add(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return bookList;
    }

    public Book findByIsbn() throws SQLException {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        Book book = null;


        try{
            Connection connection = MySQLConnection.getConnection();

            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1,"A123");

            ResultSet res = statement1.executeQuery(sql);



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return book;


    }
    public void deleteByIsbn() throws SQLException {
        String sql = "DELETE * FROM books WHERE isbn = ?";

        try{
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();


            int res = statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
