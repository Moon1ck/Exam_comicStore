package controller;

import service.AuthService;
import view.ConsoleView;

public class AuthController {
    private final AuthService authService;
    private final ConsoleView view;

    public AuthController(AuthService authService, ConsoleView view) {
        this.authService = authService;
        this.view = view;
    }

    public boolean authenticate() {
        view.showMessage("1. Войти\n2. Зарегистрироваться");
        String choice = view.prompt("Выберите вариант: ");
        String username = view.prompt("Логин: ");
        String password = view.prompt("Пароль: ");

        if (choice.equals("1")) {
            if (authService.login(username, password)) {
                view.showMessage("Успешный вход!");
                return true;
            } else {
                view.showMessage("Неверный логин или пароль.");
                return false;
            }
        } else if (choice.equals("2")) {
            authService.register(username, password);
            view.showMessage("Регистрация завершена.");
            return true;
        } else {
            view.showMessage("Неверный выбор.");
            return false;
        }
    }
}