package com.twu.biblioteca;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static com.twu.biblioteca.TestHelper.captureOutput;
import static junit.framework.Assert.assertEquals;

public class LibraryTest extends TestCase {
    @Test
    public void testLibraryConstructor(){
        assertNotNull(new Library());
    }

    @Test
    public void checkMembershipDetailsTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                BibliotecaApp.userloggedin = false;
                (new Library()).checkMembershipDetails();
                String outputString = "Please talk to the librarian. Thank you!\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

    @Test
    public void correctLoginTest() throws Exception{
        int expectedValue = 0;
        String username = "Devangana";
        String password = "abcdefg";
        Library lb = new Library();
        assertEquals(expectedValue, lb.login(username,password));
    }

    @Test
    public void loginwithIncorrectPasswordTest() throws Exception{
        int expectedValue = 1;
        String username = "Devangana";
        String password = "abcdef";
        Library lb = new Library();
        assertEquals(expectedValue, lb.login(username,password));
    }

    @Test
    public void nonexistentUserLoginTest() throws Exception{
        int expectedValue = 2;
        String username = "XYZ";
        String password = "abcdefg";
        Library lb = new Library();
        assertEquals(expectedValue, lb.login(username,password));
    }

}
