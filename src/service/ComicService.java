package service;

import data.ComicStoreData;
import model.Comic;
import model.Genre;

import java.util.*;
import java.util.stream.Collectors;

public class ComicService {
    private final List<Comic> comics;

    public ComicService() {
        this.comics = ComicStoreData.loadComics();
    }

    public void addComic(Comic comic) {
        comics.add(comic);
        save();
    }

    public void removeComic(String title) {
        comics.removeIf(c -> c.getTitle().equalsIgnoreCase(title));
        save();
    }

    public void updateComic(String title, Comic updated) {
        removeComic(title);
        addComic(updated);
    }

    public Comic findComicByTitle(String title) {
        return comics.stream()
                .filter(c -> c.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
    }

    public List<Comic> searchByAuthor(String author) {
        return comics.stream()
                .filter(c -> c.getAuthor().getFullName().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Comic> searchByGenre(Genre genre) {
        return comics.stream()
                .filter(c -> c.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public List<Comic> getAllComics() {
        return comics;
    }

    public void reserveComic(String title) {
        Comic comic = findComicByTitle(title);
        if (comic != null) {
            comic.setReserved(true);
            save();
        }
    }

    public void applyPromotion(String title, double discountPercent) {
        Comic comic = findComicByTitle(title);
        if (comic != null) {
            double discountedPrice = comic.getSalePrice() * (1 - discountPercent / 100);
            comic.setSalePrice(discountedPrice);
            comic.setOnPromotion(true);
            save();
        }
    }

    public void sellComic(String title) {
        Comic comic = findComicByTitle(title);
        if (comic != null) {
            comics.remove(comic);
            save();
        }
    }

    private void save() {
        ComicStoreData.saveComics(comics);
    }
}