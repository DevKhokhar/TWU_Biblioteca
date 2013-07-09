package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: devangnakhokhar
 * Date: 28/06/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */

class Library {
    List<Book> bookList = new ArrayList<Book>();

    Library(){
        bookList.add(new Book(1, "Head First Java", 3));
        bookList.add(new Book(2, "TDD By Example", 2));
        bookList.add(new Book(3, "Head First Ruby", 2));
    }


    private void viewAllBooks() {
        System.out.println("\nBookID\tBookName\t\tTotal Copies\tAvailable Copies");
        for(Book book : bookList){
            System.out.println(book.id + "\t\t" + book.name + "\t\t" + book.total + "\t\t\t" + book.available);
        }
    }


    private void reserveABook(){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        System.out.println("Enter the name of the book to be reserved");
        String bookname = sc.nextLine();
        for(Book book : bookList){
            if(book.name.equalsIgnoreCase(bookname)){
                if(book.check_availability_of_copies()==0)
                    System.out.println("Sorry! No copies available for this book.");
                else book.reserve();
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("Sorry, we do not have that book in our library yet!");
    }


    static void checkMembershipDetails() {
        System.out.println("Please talk to the librarian. Thank you!");
    }


    void implementChoice(int choice){
        switch (choice) {
            case 1: viewAllBooks();
                break;
            case 2: reserveABook();
                break;
            case 3: checkMembershipDetails();
                break;
        }
    }
}
