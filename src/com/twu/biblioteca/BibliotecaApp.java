package com.twu.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

class BibliotecaApp {
    static final int no_of_options = 6;
    static boolean userloggedin = false;

    static void welcomeCustomer(){
        System.out.println("Welcome to Biblioteca!!");
    }


    static void displayMenu(){
        System.out.println("\n\t***********  MENU *************");
        System.out.println("\t1. View all the books");
        System.out.println("\t2. Reserve a book");
        System.out.println("\t3. Check your membership details");
        System.out.println("\t4. View movies");
        if(userloggedin == false)
            System.out.println("\t5. Login");
        else
            System.out.println("\t5. Logout");
        System.out.println("\t6. Exit");
    }

    static boolean checkOptionValidity(int option){
        if(option<1 || option>no_of_options){
            System.out.println("Invalid Choice! Select a valid one");
            return false;
        }
        else return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lb = new Library();
        int choice = 0;

        welcomeCustomer();
        displayMenu();

        try {
            System.out.println("\nChoose an option: ");
            choice = sc.nextInt();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.exit(1);
        }


        while(choice!=no_of_options){                              // Choice 5 : Exit
            if(checkOptionValidity(choice))
                lb.implementChoice(choice);
            try {sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
            displayMenu();
            try {choice = sc.nextInt();}
            catch (InputMismatchException e){
                e.printStackTrace();
                System.exit(1);
            }
        }

        System.out.println("Thank you for using Biblioteca!");
        System.exit(0);
    }
}
