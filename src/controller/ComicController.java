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
        try {
            Comic comic = view.readComicData();
            comicService.addComic(comic);
            view.showMessage("Комикс добавлен.");
        } catch (Exception e) {
            view.showMessage("Ошибка при добавлении комикса: " + e.getMessage());
        }
    }

    public void removeComic() {
        try {
            String title = view.prompt("Введите название комикса для удаления: ");
            comicService.removeComic(title);
            view.showMessage("Комикс удалён.");
        } catch (Exception e) {
            view.showMessage("Ошибка при удалении комикса: " + e.getMessage());
        }
    }

    public void editComic() {
        try {
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
        } catch (Exception e) {
            view.showMessage("Ошибка при редактировании: " + e.getMessage());
        }
    }

    public void searchByAuthor() {
        try {
            String authorName = view.prompt("Введите имя автора: ");
            List<Comic> comics = comicService.searchByAuthor(authorName);
            view.showComics(comics);
        } catch (Exception e) {
            view.showMessage("Ошибка при поиске по автору: " + e.getMessage());
        }
    }

    public void searchByGenre() {
        try {
            Genre genre = view.readGenre();
            List<Comic> comics = comicService.searchByGenre(genre);
            view.showComics(comics);
        } catch (Exception e) {
            view.showMessage("Ошибка при поиске по жанру: " + e.getMessage());
        }
    }

    public void listAllComics() {
        try {
            view.showComics(comicService.getAllComics());
        } catch (Exception e) {
            view.showMessage("Ошибка при отображении списка комиксов: " + e.getMessage());
        }
    }

    public void reserveComic() {
        try {
            String title = view.prompt("Введите название комикса для бронирования: ");
            comicService.reserveComic(title);
            view.showMessage("Комикс отложен.");
        } catch (Exception e) {
            view.showMessage("Ошибка при бронировании комикса: " + e.getMessage());
        }
    }

    public void applyPromotion() {
        try {
            String title = view.prompt("Введите название комикса для акции: ");
            double discount = Double.parseDouble(view.prompt("Скидка в %: "));
            comicService.applyPromotion(title, discount);
            view.showMessage("Скидка применена.");
        } catch (NumberFormatException e) {
            view.showMessage("Неверный формат числа для скидки. Введите число, например: 10.0");
        } catch (Exception e) {
            view.showMessage("Ошибка при применении акции: " + e.getMessage());
        }
    }

    public void sellComic() {
        try {
            String title = view.prompt("Введите название комикса для продажи: ");
            comicService.sellComic(title);
            view.showMessage("Комикс продан.");
        } catch (Exception e) {
            view.showMessage("Ошибка при продаже комикса: " + e.getMessage());
        }
    }
}