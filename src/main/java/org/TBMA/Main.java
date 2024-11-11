package org.TBMA;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
     //   BookConsoleView app = new BookConsoleView();
     //   app.printMenu();
        MySQLBookRepository bookRepository = new MySQLBookRepository();

        Book newBook = new Book("Clean Code", "Uncle Bob", "A124");
        bookRepository.save(newBook);

        List<Book> list = bookRepository.findAll();

        for (Book book : list) {
            System.out.println(book);
        }


    }
}
