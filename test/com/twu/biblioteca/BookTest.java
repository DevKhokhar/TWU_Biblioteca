package com.twu.biblioteca;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class BookTest extends TestCase {
    @Test
    public void testBookConstructor(){
        Assert.assertNotNull(new Book(4,"TestBook",4));
    }

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
