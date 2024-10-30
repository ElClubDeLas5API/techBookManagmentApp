package org.TBMA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = {
                "1. Añadir libro",
                "2. Ver todos los libros",
                "3. Eliminar libro",
                "4. Cambiar repositorio",
                "5. Salir"
        };

        byte option = 0;

        while (option != 5) {
            for (String item : menu) {
                System.out.println(item);
            }
            System.out.println("Seleccione una opción:");

            String input = scanner.nextLine();

            try {
                option = Byte.parseByte(input);
            } catch (Exception ex) {
                System.out.println("Esto no es un número");
                continue;
            }

            if (option < 1 || option > 5) {
                System.out.println("Número fuera de rango");
                continue;
            }

            System.out.println("Ha elegido: " + menu[option - 1]);
        }
    }
}
