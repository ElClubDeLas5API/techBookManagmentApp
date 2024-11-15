package org.TBMA;

import org.TBMA.presentation.BookConsoleView;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        BookConsoleView app = new BookConsoleView();
        app.printMenu();

    }
}
