package org.TBMA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
