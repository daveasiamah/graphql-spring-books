package com.david.graphqlstart.model;

public enum Rating{
    FIVE_STARS("*****"),
    FOUR_STARS("****"),
    THREE_STARS("***"),
    TWO_STARS("**"),
    ONE_STAR("*");

    private final String star;

    Rating(String star){
        this.star = star;
    }

    public String getStar() {
        return star;
    }
}
