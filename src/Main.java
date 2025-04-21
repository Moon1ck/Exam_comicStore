import controller.AuthController;
import controller.ComicController;
import service.AuthService;
import service.ComicService;
import view.ConsoleView;
import view.MenuHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        AuthController authController = new AuthController(new AuthService(), view);

        if (!authController.authenticate()) {
            return;
        }

        ComicController comicController = new ComicController(new ComicService(), view);
        new MenuHandler(comicController, view).start();
    }
}