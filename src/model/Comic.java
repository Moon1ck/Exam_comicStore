package model;

import java.io.Serializable;

public class Comic implements Serializable {
    private String title;
    private Author author;
    private String publisher;
    private int pages;
    private Genre genre;
    private int year;
    private double costPrice;
    private double salePrice;
    private boolean isSequel;
    private boolean reserved;
    private boolean onPromotion;

    public Comic(String title, Author author, String publisher, int pages, Genre genre, int year,
                 double costPrice, double salePrice, boolean isSequel) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.genre = genre;
        this.year = year;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.isSequel = isSequel;
        this.reserved = false;
        this.onPromotion = false;
    }

    // Геттеры и сеттеры

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public boolean isSequel() {
        return isSequel;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isOnPromotion() {
        return onPromotion;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setOnPromotion(boolean onPromotion) {
        this.onPromotion = onPromotion;
    }

    @Override
    public String toString() {
        return String.format("Название: %s | Автор: %s | Жанр: %s | Год: %d | Цена: %.2f",
                title, author.getFullName(), genre, year, salePrice);
    }
}
