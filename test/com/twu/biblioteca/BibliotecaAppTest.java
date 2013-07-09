package com.twu.biblioteca;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: devangnakhokhar
 * Date: 09/07/13
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaAppTest {
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
