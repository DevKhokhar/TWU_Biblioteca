package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void userConstructorTest(){
        User user = new User("Devangana", "111-1111", "abcdefg", "devangak@thoughtworks.com", "9999999999");
        Assert.assertNotNull(user);
    }
}
