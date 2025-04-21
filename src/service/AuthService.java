package service;

import data.ComicStoreData;
import model.User;

import java.util.List;

public class AuthService {
    private final List<User> users;

    public AuthService() {
        this.users = ComicStoreData.loadUsers();
    }

    public boolean login(String username, String password) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }

    public void register(String username, String password) {
        users.add(new User(username, password));
        ComicStoreData.saveUsers(users);
    }
}