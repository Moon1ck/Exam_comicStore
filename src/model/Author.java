package model;

import java.io.Serializable;

public class Author implements Serializable {
    private String fullName;

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}