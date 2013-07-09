package com.twu.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

class BibliotecaApp {

    private static void welcomeCustomer(){
        System.out.println("Welcome to Biblioteca!!");
    }


    private static void displayMenu(){
            System.out.println("\n\t***********  MENU *************");
            System.out.println("\t1. View all the books");
            System.out.println("\t2. Reserve a book");
            System.out.println("\t3. Check your membership details");
            System.out.println("\t4. Exit");
    }

    static boolean checkOptionValidity(int option){
        if(option<1 || option>4){
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


        while(choice!=4){                              // Choice 4 : Exit
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
