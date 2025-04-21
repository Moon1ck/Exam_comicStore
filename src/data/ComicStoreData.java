package data;

import model.Comic;
import model.User;

import java.io.*;
import java.util.*;

public class ComicStoreData {
    private static final String COMICS_FILE = "comics.dat";
    private static final String USERS_FILE = "users.dat";

    public static List<Comic> loadComics() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COMICS_FILE))) {
            return (List<Comic>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveComics(List<Comic> comics) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMICS_FILE))) {
            oos.writeObject(comics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            return (List<User>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}