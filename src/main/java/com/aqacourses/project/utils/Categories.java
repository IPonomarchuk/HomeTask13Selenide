package com.aqacourses.project.utils;

public enum Categories {
    WOMEN("Women"),
    TOPS("Tops"),
    TSHIRTS("T-shirts"),
    DRESSES("Dresses"),
    BLOUSES("Blouses"),
    CASUAL_DRESSES("Casual Dresses"),
    EVENING_DRESSES("Evening Dresses"),
    SUMMER_DRESSES("Summer Dresses");

    private final String text;

    /** @param text */
    Categories(final String text) {
        this.text = text;
    }

    // Enum to String
    @Override
    public String toString() {
        return text;
    }
}
