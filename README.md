# Sistema de Gestión de Biblioteca en Java

Este proyecto implementa un sistema simple de gestión de biblioteca en Java, permitiendo realizar operaciones básicas sobre una colección de libros.

## Funcionalidades

El sistema ofrece las siguientes funcionalidades:

1. **Ver todos los libros**: Muestra una lista de todos los libros almacenados en el sistema.
2. **Añadir un nuevo libro**: Permite al usuario agregar un nuevo libro a la colección.
3. **Eliminar un libro**: Permite al usuario eliminar un libro existente de la colección.
4. **Salir de la aplicación**: Termina la ejecución del programa.

## Estructura del Proyecto

El proyecto consta de tres archivos principales:

1. `Main.java`: Punto de entrada de la aplicación.
2. `Application.java`: Contiene la lógica principal de la aplicación y el menú interactivo.
3. `Book.java`: Define la clase Book para representar los libros.

### Main.java

Inicializa la aplicación y llama al método para mostrar el menú.

### Application.java

Contiene la lógica principal, incluyendo:
- Menú interactivo
- Métodos para añadir, eliminar y mostrar libros
- Validación de entrada de usuario

### Book.java

Define la estructura de un libro con:
- Título
- Autor
- ISBN

## Cómo usar

1. Ejecute la