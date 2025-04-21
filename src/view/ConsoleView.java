package view;

import model.Comic;
import model.Author;
import model.Genre;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public Comic readComicData() {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Автор: ");
        String authorName = scanner.nextLine();
        Author author = new Author(authorName);
        System.out.print("Издательство: ");
        String publisher = scanner.nextLine();
        System.out.print("Количество страниц: ");
        int pages = Integer.parseInt(scanner.nextLine());
        Genre genre = readGenre();
        System.out.print("Год: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Себестоимость: ");
        double costPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Цена продажи: ");
        double salePrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Это продолжение? (true/false): ");
        boolean isSequel = Boolean.parseBoolean(scanner.nextLine());

        return new Comic(title, author, publisher, pages, genre, year, costPrice, salePrice, isSequel);
    }

    public Genre readGenre() {
        System.out.println("Выберите жанр:");
        for (Genre g : Genre.values()) {
            System.out.println("- " + g.name());
        }
        return Genre.valueOf(scanner.nextLine().toUpperCase());
    }

    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showComics(List<Comic> comics) {
        if (comics.isEmpty()) {
            System.out.println("Нет комиксов.");
            return;
        }
        for (Comic comic : comics) {
            System.out.println(comic);
        }
    }

    public void showComic(Comic comic) {
        System.out.println(comic);
    }
}