package com.twu.biblioteca;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;


public class MovieTest extends TestCase {
    @Test
    public void testMovieConstructorwithRating(){
        Assert.assertNotNull(new Movie("The Notebook", 2004, "Nick Cassavates"));
    }

    @Test
    public void testMovieConstructorwithoutRating(){
        Assert.assertNotNull(new Movie("The Notebook", 2004, "Nick Cassavates",9));
    }
}
