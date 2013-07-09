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
        Assert.assertNotNull(new Library());
    }

    @Test
    public void checkMembershipDetailsTest() throws Exception {
        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                Library.checkMembershipDetails();
                String outputString = "Please talk to the librarian. Thank you!\n";
                assertEquals(outputString, outContent.toString());
            }
        });
    }

}
