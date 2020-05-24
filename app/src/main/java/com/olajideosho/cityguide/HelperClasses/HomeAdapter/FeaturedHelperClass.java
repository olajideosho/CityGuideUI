package com.olajideosho.cityguide.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    int image;
    String title, description;
    String color;

    public FeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public FeaturedHelperClass(int image, String title, String description, String color) {
        this(image, title, description);
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }
}
