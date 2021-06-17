package deeperJunit;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void tryAssertTrue(){
        Rectangle rectangle = new Rectangle(10,10);
        assertTrue(rectangle.isSquare());
    }

    @Test
    public void tryAssertFalse(){
        Rectangle rectangle = new Rectangle(1,10);
        assertFalse(rectangle.isSquare());
    }

    @Test
    public void tryAssertTrue2(){
        Rectangle rectangle = new Rectangle(10,10);
        assertTrue("Rectangle that the width and height should be square", rectangle.isSquare());
    }

    @Test
    public void tryAssertNull(){
        Object value = null;
        assertNull(value);
    }

    @Test
    public void tryAssertNotNull(){
        Object value = new Rectangle(1,1);
        assertNotNull(value);
    }

    @Test
    public void tryAssertEquals(){
        assertEquals(16, new Rectangle(2,8).getArea());
    }

    @Test(expected = IOException.class)
    public void willThrowThrows() throws Exception {
        Rectangle.willThrow();
    }

}