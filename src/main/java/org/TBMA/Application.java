package org.TBMA;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private ArrayList <Book>  repoBooks1 = new ArrayList<>();

    public Application() {
        this.repoBooks1.add(new Book("A123", "Effective Java", "Joshua Bloch"));
        this.repoBooks1.add(new Book("A123", "Effective Java", "Joshua Bloch"));
    }


    public void printMenu() {

        Scanner scanner = new Scanner(System.in);
        String[] menu = {"1.Ver todos los libros ", "2. Añadir libro", "3. Eliminar libro", "4. Cambiar repositorio", "5. Salir"};

        byte option = 0;

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

            this.optionSelector(option);

            System.out.println("------------------------------------------");

        }

    }

    private void optionSelector(byte option) {
        if(option == 1){
            this.printList();
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
}
