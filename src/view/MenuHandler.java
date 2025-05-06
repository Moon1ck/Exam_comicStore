package view;

import controller.ComicController;

public class MenuHandler {
    private final ComicController comicController;
    private final ConsoleView view;

    public MenuHandler(ComicController comicController, ConsoleView view) {
        this.comicController = comicController;
        this.view = view;
    }

    public void start() {
        while (true) {
            try {
                showMenu();
                switch (view.prompt("Ваш выбор: ")) {
                    case "1" -> comicController.addComic();
                    case "2" -> comicController.removeComic();
                    case "3" -> comicController.editComic();
                    case "4" -> comicController.sellComic();
                    case "5" -> comicController.reserveComic();
                    case "6" -> comicController.applyPromotion();
                    case "7" -> comicController.searchByAuthor();
                    case "8" -> comicController.searchByGenre();
                    case "9" -> comicController.listAllComics();
                    case "0" -> {
                        view.showMessage("Выход из системы...");
                        return;
                    }
                    default -> view.showMessage("Неверный выбор.");
                }
            } catch (Exception e) {
                view.showMessage("Ошибка выполнения операции: " + e.getMessage());
            }
        }
    }

    private void showMenu() {
        view.showMessage("\n==== МЕНЮ ====");
        view.showMessage("1. Добавить комикс");
        view.showMessage("2. Удалить комикс");
        view.showMessage("3. Редактировать комикс");
        view.showMessage("4. Продать комикс");
        view.showMessage("5. Отложить комикс");
        view.showMessage("6. Применить акцию");
        view.showMessage("7. Поиск по автору");
        view.showMessage("8. Поиск по жанру");
        view.showMessage("9. Показать все комиксы");
        view.showMessage("0. Выход");
    }
}
