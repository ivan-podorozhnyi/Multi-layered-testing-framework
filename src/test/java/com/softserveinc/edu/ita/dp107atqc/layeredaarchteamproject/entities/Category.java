package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities;


import java.util.Objects;

public final class Category {

    private final String category;

    public Category(String category) {
        if (category == null) {
            throw new NullPointerException("category is null");
        }
        this.category = category;
    }

//    @Override
//    public String toString() {
//        return "Category{" +
//                "category='" + category + '\'' +
//                '}';
//    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category1 = (Category) o;
        return Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }
}
