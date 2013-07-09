package com.twu.biblioteca;

class Book {
    int id;
    String name;
    int total;
    int available;

    Book(int id, String name, int total){
        this.id = id;
        this.name = name;
        this.total = total;
        this.available = total;
    }

    int check_availability_of_copies(){
        return this.available;
    }

    void reserve(){
        this.available--;
        System.out.println("Thank you! Enjoy the book!");
    }
}
