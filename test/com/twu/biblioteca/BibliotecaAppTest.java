package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static com.twu.biblioteca.TestHelper.captureOutput;
import static junit.framework.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void welcomeCustomerTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                BibliotecaApp.welcomeCustomer();
                String outputString = "Welcome to Biblioteca!!\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

    @Test
    public void displayLoginMenuTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                BibliotecaApp.userloggedin = true;
                BibliotecaApp.displayMenu();
                String outputString = "\n\t***********  MENU *************\n" + "\t1. View all the books\n" + "\t2. Reserve a book\n" + "\t3. Check your membership details\n" + "\t4. View movies\n" + "\t5. Logout\n" + "\t6. Exit\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

    @Test
    public void displayLogoutMenuTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                BibliotecaApp.userloggedin = false;
                BibliotecaApp.displayMenu();
                String outputString = "\n\t***********  MENU *************\n" + "\t1. View all the books\n" + "\t2. Reserve a book\n" + "\t3. Check your membership details\n" + "\t4. View movies\n" + "\t5. Login\n" + "\t6. Exit\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

    @Test
    public void negativeNumberAsUserSelection(){
        boolean expectedValue = false;
        int option = -1;
        assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void zeroAsUserSelection(){
        boolean expectedValue = false;
        int option = 0;
        assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void numberBetweenOneAndFiveInclusiveAsUserSelection(){
        boolean expectedValue = true;
        int option = 2;
        assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void numberGreaterThanSixAsUserSelection(){
        boolean expectedValue = false;
        int option = 7;
        assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }
}
