package org.ies.library.components;

import org.ies.library.model.Author;
import org.ies.library.model.Book;

import java.util.Scanner;

public class BookReader {

    private final Scanner scanner;
    private final AuthorReader authorReader;

    public BookReader(Scanner scanner, AuthorReader authorReader) {
        this.scanner = scanner;
        this.authorReader = authorReader;
    }

    public Book read() {
        System.out.println("Introduce los siguientes datos del libro");
        System.out.println("ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Título");
        String title = scanner.nextLine();
        System.out.println("Año publicacion");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Cuantos autores tiene el libro?");
        int size = scanner.nextInt();
        scanner.nextLine();

        Author[] authors = new Author[size];
        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorReader.read();

        }

        return new Book(
                isbn,
                title,
                year,
                authors
        );
    }
}
