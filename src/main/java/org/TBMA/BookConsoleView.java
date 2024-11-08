package org.TBMA;

import java.util.Scanner;

public class BookConsoleView {

    private final BookManager bookManager = new BookManager();

    String[] menu = {"\n1.Ver todos los libros ", "2. Añadir libro", "3. Eliminar libro", "4. Cambiar repositorio", "5. Salir"};

    public void printMenu() {

        Scanner scanner = getScanner();
        byte option = 0;
        menuFilter(option, scanner);
    }

    private static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    private void menuFilter(byte option, Scanner scanner)  {
        while (option != 5) {
            for (String item : menu) {
                System.out.println(item);
            }
            System.out.println("\nSeleccione una opción:");

            String input = scanner.nextLine();

            try {
                option = Byte.parseByte(input);
            } catch (Exception ex) {
                System.out.println("Esto no es un número");
                System.out.println("------------------------------------------");
                continue;
            }

            if (option < 1 || option > 5) {
                System.out.println("Número fuera de rango");
                System.out.println("------------------------------------------");
                continue;
            }

            System.out.println("\nHa elegido: " + menu[option - 1]);
            System.out.println("------------------------------------------");

            this.optionSelector(option);
        }
    }

    private void optionSelector(byte option)  {
        Scanner scanner = getScanner();
        switch (option) {
            case 1:
                this.printList();
                break;
            case 2:
                this.printAddBookMenu(scanner);
                break;
            case 3:
                this.printDeleteBookMenu(scanner);
                break;
        }
    }

    private void printList() {
        if (bookManager.getGetRepoBooks1().isEmpty()) {
            System.out.println("No hay libros guardados");
            return;
        }
        System.out.println("\nLista de Libros: ");
        for (Book book : bookManager.getGetRepoBooks1()) {
            System.out.println("    ··········       ");
            System.out.println(book.toString());
        }
    }


    private void printDeleteBookMenu(Scanner scanner) {
        String userISBN;
        System.out.println("\nIngrese un ISBN:");
        userISBN = scanner.nextLine();

        if (userISBN.isEmpty()) {
            System.out.println("Campo obligatorio. Por favor, intente nuevamente.");
        }
        if (!userISBN.matches("^[a-zA-Z][0-9]{3}$")) {
            System.out.println("Formato incorrecto, debe contener una letra seguida de tres números");
            userISBN = "";
        }
        try {
            bookManager.deleteBook((userISBN));
            System.out.println("Libro eliminado con éxito.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void printAddBookMenu(Scanner scanner) {
        String userISBN;
        String userAutor;
        String userTitulo;
        System.out.println("\nIngrese un titulo:");
        userTitulo = scanner.nextLine();
        System.out.println("\nIngrese un autor:");
        userAutor = scanner.nextLine();
        System.out.println("\nIngrese un ISBN:");
        userISBN = scanner.nextLine();


        if (userTitulo.isEmpty() || userAutor.isEmpty() || userISBN.isEmpty()) {
            System.out.println("Todos los campos son obligatorios. Por favor, intente nuevamente.");
            return;
        }
        if (!userISBN.matches("^[a-zA-Z][0-9]{3}$")) {
            System.out.println("Formato incorrecto, debe contener una letra seguida de tres números");
            return;
        }
        try {
            bookManager.addBook(new Book(userTitulo, userAutor, userISBN));
            System.out.println("Libro añadido con éxito.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

}
