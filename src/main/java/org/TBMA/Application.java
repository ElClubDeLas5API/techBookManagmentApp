package org.TBMA;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    private ArrayList<Book> repoBooks1 = new ArrayList<>();

    public Application() {
        this.repoBooks1.add(new Book("Effective Java", "Joshua Bloch", "A123"));
        this.repoBooks1.add(new Book("Effective Java", "Joshua Bloch", "A123"));
    }

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

    private void menuFilter(byte option, Scanner scanner) {
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

    private void optionSelector(byte option) {

        switch (option) {
            case 1:
                this.printList();
                break;
            case 2:
                this.addBook();
                break;
            case 3:
                this.deleteBook();
                break;
        }

    }

    private void printList() {
        if (repoBooks1.isEmpty()) {
            System.out.println("No hay libros guardados");
            return;
        }
        System.out.println("\nLista de Libros: ");
        for (Book book : repoBooks1) {
            System.out.println("    ··········       ");
            System.out.println(book.toString());
        }
    }

    private Book getBookData(int caseIndex) {
        Scanner scanner = getScanner();
        String userTitulo;
        String userAutor ;
        String userISBN ;
        switch (caseIndex) {
            case 2:
                System.out.println("\nIngrese un titulo:");
                userTitulo = scanner.nextLine();
                System.out.println("\nIngrese un autor:");
                userAutor = scanner.nextLine();
                System.out.println("\nIngrese un ISBN:");
                userISBN = scanner.nextLine();

                if (userTitulo.isEmpty() || userAutor.isEmpty() || userISBN.isEmpty()) {
                    System.out.println("Todos los campos son obligatorios. Por favor, intente nuevamente.");
                }
                if (!userISBN.matches("^[a-zA-Z][0-9]{3}$")) {
                    System.out.println("Formato incorrecto, debe contener una letra seguida de tres números");
                    userISBN = "";
                }

                return new Book(userTitulo, userAutor, userISBN);
            case 3:
                System.out.println("\nIngrese un ISBN:");
                userISBN = scanner.nextLine();

                if (userISBN.isEmpty()) {
                    System.out.println("Campo obligatorio. Por favor, intente nuevamente.");
                }
                if (!userISBN.matches("^[a-zA-Z][0-9]{3}$")) {
                    System.out.println("Formato incorrecto, debe contener una letra seguida de tres números");
                    userISBN = "";
                }

                return new Book("","",userISBN);
        }

        return new Book("","","");
    }

    private int isBookInList(String uISBN) {
        for (Book book : repoBooks1) {
            String getterIsbn = book.getISBN();
            if ((Objects.equals(uISBN, getterIsbn))) {
                return repoBooks1.indexOf(book);

            }
        }
        return -1;
    }

    private void addBook() {
        Book newBook = getBookData(2);
        int inListIndex = isBookInList(newBook.getISBN());
        String isbnNewBook = newBook.getISBN();

        if (isbnNewBook.isEmpty()) {
            return;
        }

        if (inListIndex >= 0) {
            System.out.println("El libro ya existe en la lista.");
            return;
        }

        repoBooks1.add(newBook);
        System.out.println("Libro añadido con éxito.");

    }

    private void deleteBook(){
        Book deleteISBN = getBookData(3);
        int index = isBookInList(deleteISBN.getISBN());
        String isbnDeleteBook = deleteISBN.getISBN();

        if (index == -1) {
            System.out.println("El ISBN introducido no existe.");
            return;
        }

         repoBooks1.remove(index);
        System.out.println("Libro eliminado con éxito.");
    }

}
