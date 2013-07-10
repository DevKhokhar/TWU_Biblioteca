package com.twu.biblioteca;

public class Movie {
    String name;
    int year;
    String director;
    int rating = 0;

    Movie(String name, int year, String director){
        this.name = name;
        this.year = year;
        this.director = director;
    }

    Movie(String name, int year, String director, int rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

}
