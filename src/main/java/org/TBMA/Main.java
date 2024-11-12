package org.TBMA;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
//        BookConsoleView app = new BookConsoleView();
//        app.printMenu();
//        List<Book> list = bookRepository.findAll();

//        for (Optional<Book> book : list) {
//            System.out.println(book);
//        }
//        Book newBook = new Book("Clean Code", "Uncle Bob", "A125");
//        bookRepository.save(newBook);
//        Optional<Book> list = (Optional<Book>) bookRepository.findByIsbn("A124");

        MySQLBookRepository bookRepository = new MySQLBookRepository();

        Optional<Book> list = (Optional<Book>) bookRepository.deleteByIsbn("A124");
        System.out.println(list);

    }
}
