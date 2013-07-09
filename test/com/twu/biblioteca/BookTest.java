package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: devangnakhokhar
 * Date: 09/07/13
 * Time: 10:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest extends TestCase {
    @Test
    public void testNonAvailability(){
        Book testbook = new Book(4,"TestBook",4);
        testbook.available = 0;
        int expectedValue = 0;
        assertEquals(expectedValue, testbook.check_availability_of_copies());
    }

    @Test
    public void testAvailability(){
        Book testbook = new Book(4,"TestBook",2);
        int expectedValue = 2;
        assertEquals(expectedValue,testbook.check_availability_of_copies());
    }
}
