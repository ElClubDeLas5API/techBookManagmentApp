# Sistema de Gestión de Biblioteca en Java

Este proyecto implementa un sistema de gestión de biblioteca en Java que permite a los usuarios realizar operaciones básicas sobre una colección de libros técnicos de programación a través de una interfaz en consola.

## Objetivos de Aprendizaje

- Introducción a Java y Programación Orientada a Objetos (OOP).
- Desarrollo de un proyecto incremental con enfoque en refactorización.
- Aproximación a la arquitectura y patrones de diseño utilizados en Spring.
- Implementación de tests unitarios básicos.

## Descripción General

La aplicación de consola permite a los usuarios gestionar una colección de libros técnicos de programación. A través de un menú interactivo, los usuarios pueden:

1. **Ver todos los libros**: Muestra una lista de todos los libros almacenados en el sistema.
2. **Añadir un nuevo libro**: Permite agregar un libro a la colección ingresando el título, autor y ISBN.
3. **Eliminar un libro**: Elimina un libro específico de la colección.
4. **Salir de la aplicación**: Finaliza el programa.

---

## Tabla de Contenidos

1. [Funcionalidades](#funcionalidades)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Instalación](#instalación)
4. [Uso](#uso)
5. [Características](#características)
6. [Contribución](#contribución)
7. [Autores y Agradecimientos](#autores-y-agradecimientos)
8. [Diagrama UML](#diagrama-UML)
9. [Contacto](#contacto)

## Funcionalidades

1. **Ver todos los libros**: Presenta una lista con los libros en la colección.
2. **Añadir un nuevo libro**: Permite introducir un nuevo libro con título, autor e ISBN (una letra seguida de tres números).
3. **Eliminar un libro**: Elimina un libro de la colección al ingresar su ISBN.
4. **Salir de la aplicación**: Termina la ejecución del programa.

## Estructura del Proyecto

El proyecto está compuesto por tres archivos principales:

- **Main.java**: Punto de entrada de la aplicación. Inicializa el sistema y llama al método para mostrar el menú interactivo.
- **Application.java**: Contiene la lógica principal de la aplicación, incluyendo el menú, los métodos de añadir, eliminar y ver libros, y validaciones de entrada del usuario.
- **Book.java**: Define la estructura de un libro con los atributos título, autor e ISBN.

---

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://[github.com/usuario/tech-books-manager-app.git](https://github.com/ElClubDeLas5API/techBookManagmentApp.git)
## Uso
Al iniciar el sistema, verás un menú interactivo con las siguientes opciones:
  1. Ver todos los libros
  2. Añadir libro
  3. Eliminar libro
  4. Cambiar repositorio
  5. Salir
A continuación deberás seleccionar la opción deseada:
    Seleccione una opción: "1"
Ha elegido: 
  1.Ver todos los libros 
  ------------------------------------------
  
  Lista de Libros: 
      ··········       
  Titulo: Effective Java
  Autor: Joshua Bloch
  ISBN: A123
      ··········       
  Titulo: Effective Java
  Autor: Joshua Bloch
  ISBN: A123


## Características

- **Ver todos los libros**: 
  - Permite a los usuarios visualizar una lista completa de todos los libros almacenados en el sistema.

- **Añadir un nuevo libro**: 
  - Facilita a los usuarios la adición de nuevos libros proporcionando el título, autor e ISBN (debe tener el formato de una letra seguida de tres números).

- **Eliminar un libro**: 
  - Permite a los usuarios eliminar un libro existente de la colección introduciendo el ISBN correspondiente.

- **Validación de entradas**: 
  - Asegura que todos los campos son obligatorios al añadir un libro y que el ISBN tiene el formato correcto.
  - Notifica al usuario si intenta añadir un libro con un ISBN que ya existe o si proporciona entradas inválidas.

- **Interfaz interactiva**: 
  - Proporciona un menú en la consola que permite al usuario seleccionar acciones como añadir, ver o eliminar libros.

- **Mensajes informativos**: 
  - Informa al usuario sobre el éxito de las operaciones realizadas y muestra mensajes claros en caso de errores.

## Contribución



## Autores y Agradecimientos

Paula Calvo ![https://www.linkedin.com/in/paulacalvogarcia2001/]( icons8-linkedin-48.png "Logo linkedIn")
Carla Sanchez ![https://www.linkedin.com/in/carla-sanchez24]( icons8-linkedin-48.png "Logo linkedIn")

Miguel Reyes ![https://www.linkedin.com/in/miguelreyesvasquez/]( icons8-linkedin-48.png "Logo linkedIn")
Luis Aranguren ![https://github.com/luisarangurnn]( icons8-linkedin-48.png "Logo linkedIn")

Aron Cosmo  ![]( icons8-linkedin-48.png "Logo linkedIn")




## Diagrama UML
![image](https://github.com/user-attachments/assets/404e6bd2-3e19-451e-a217-1f8d6852d82b)




## Contacto


