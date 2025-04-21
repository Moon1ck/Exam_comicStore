package controller;

import model.Comic;
import model.Genre;
import model.Author;
import service.ComicService;
import view.ConsoleView;

import java.util.List;

public class ComicController {
    private final ComicService comicService;
    private final ConsoleView view;

    public ComicController(ComicService comicService, ConsoleView view) {
        this.comicService = comicService;
        this.view = view;
    }

    public void addComic() {
        Comic comic = view.readComicData();
        comicService.addComic(comic);
        view.showMessage("Комикс добавлен.");
    }

    public void removeComic() {
        String title = view.prompt("Введите название комикса для удаления: ");
        comicService.removeComic(title);
        view.showMessage("Комикс удалён.");
    }

    public void editComic() {
        String title = view.prompt("Введите название комикса для редактирования: ");
        Comic comic = comicService.findComicByTitle(title);
        if (comic != null) {
            view.showComic(comic);
            Comic updated = view.readComicData();
            comicService.updateComic(title, updated);
            view.showMessage("Комикс обновлён.");
        } else {
            view.showMessage("Комикс не найден.");
        }
    }

    public void searchByAuthor() {
        String authorName = view.prompt("Введите имя автора: ");
        List<Comic> comics = comicService.searchByAuthor(authorName);
        view.showComics(comics);
    }

    public void searchByGenre() {
        Genre genre = view.readGenre();
        List<Comic> comics = comicService.searchByGenre(genre);
        view.showComics(comics);
    }

    public void listAllComics() {
        view.showComics(comicService.getAllComics());
    }

    public void reserveComic() {
        String title = view.prompt("Введите название комикса для бронирования: ");
        comicService.reserveComic(title);
        view.showMessage("Комикс отложен.");
    }

    public void applyPromotion() {
        String title = view.prompt("Введите название комикса для акции: ");
        double discount = Double.parseDouble(view.prompt("Скидка в %: "));
        comicService.applyPromotion(title, discount);
        view.showMessage("Скидка применена.");
    }

    public void sellComic() {
        String title = view.prompt("Введите название комикса для продажи: ");
        comicService.sellComic(title);
        view.showMessage("Комикс продан.");
    }
}