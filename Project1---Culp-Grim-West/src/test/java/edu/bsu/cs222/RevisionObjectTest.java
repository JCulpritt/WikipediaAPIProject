package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RevisionObjectTest {
    @Test
    public void constructorTest() {
        Revision result = new Revision("Joseph Culp", "12:37PM");
        Assertions.assertEquals("12:37PM\tJoseph Culp",result.toString());
    }
    @Test
    public void redirectNullTest(){
        Revision result = new Revision("Joseph", "12:37PM");
        Assertions.assertNull(result.getRedirect());
    }
    @Test
    public void setAndGetRedirectTest() {
        Revision result = new Revision("Joseph", "12:37PM");
        result.setRedirect("Karter West and Garrett Grim");
        Assertions.assertEquals("Karter West and Garrett Grim", result.getRedirect());
    }
}
