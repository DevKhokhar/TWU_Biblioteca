package com.twu.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: devangnakhokhar
 * Date: 28/06/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
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
