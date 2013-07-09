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
    public void displayMenuTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                BibliotecaApp.displayMenu();
                String outputString = "\n\t***********  MENU *************\n" + "\t1. View all the books\n" + "\t2. Reserve a book\n" + "\t3. Check your membership details\n" + "\t4. Exit\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

    @Test
    public void negativeNumberAsUserSelection(){
        boolean expectedValue = false;
        int option = -1;
        org.junit.Assert.assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void zeroAsUserSelection(){
        boolean expectedValue = false;
        int option = 0;
        org.junit.Assert.assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void numberBetweenOneAndFourInclusiveAsUserSelection(){
        boolean expectedValue = true;
        int option = 2;
        org.junit.Assert.assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }

    @Test
    public void numberGreaterThanFourAsUserSelection(){
        boolean expectedValue = false;
        int option = 5;
        org.junit.Assert.assertEquals(expectedValue, BibliotecaApp.checkOptionValidity(option));
    }
}
