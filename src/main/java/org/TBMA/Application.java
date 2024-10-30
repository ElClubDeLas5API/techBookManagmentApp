package org.TBMA;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private ArrayList <Book>  repoBooks1 = new ArrayList<>();

    public Application() {
        this.repoBooks1.add(new Book("A123", "Effective Java", "Joshua Bloch"));
        this.repoBooks1.add(new Book("A123", "Effective Java", "Joshua Bloch"));
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

        switch (option){
            case 1:
                this.printList();
                break;
            case 2:
                this.addBook();
                break;
        }

    }

    private void printList () {
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


    private Book getBookData () {
        Scanner scanner = getScanner();
        System.out.println("\nIngrese un titulo:");
        String getTitulo = scanner.nextLine();
        System.out.println("\nIngrese un autor:");
        String getAutor = scanner.nextLine();
        System.out.println("\nIngrese un ISBN:");
        String getISBN = scanner.nextLine();

        return new Book (getTitulo,getAutor,getISBN);
    }

    private void addBook (){
        Book newBook =  getBookData();
        repoBooks1.add(newBook);
    }
}
