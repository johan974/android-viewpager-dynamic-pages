package nl.deholtmans.viewpagerdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PageAdminTest {
    @Test
    public void testPaginationForward() {
        // Basic start
        PageAdmin pageAdmin = new PageAdmin( 12, 1, 10);
        assertEquals( 12, pageAdmin.updatePosition( 1));
        assertEquals( 11, pageAdmin.updatePosition( 0));
        assertEquals( 13, pageAdmin.updatePosition( 2));

        assertEquals( 14, pageAdmin.updatePosition( 3));
        assertEquals( 15, pageAdmin.updatePosition( 4));
        assertEquals( 16, pageAdmin.updatePosition( 5));
        assertEquals( 17, pageAdmin.updatePosition( 6));
        assertEquals( 18, pageAdmin.updatePosition( 7));
        assertEquals( 19, pageAdmin.updatePosition( 8));
        assertEquals( 20, pageAdmin.updatePosition( 9));
        assertEquals( 21, pageAdmin.updatePosition( 10));
        assertEquals( 22, pageAdmin.updatePosition( 11));
        assertEquals( 22, pageAdmin.updatePosition( 1));
        assertEquals( 21, pageAdmin.getPage( 0));
        assertEquals( 23, pageAdmin.getPage( 2));
        assertEquals( 24, pageAdmin.updatePosition( 3));
    }

    @Test
    public void testPaginationBackward() {
        // Basic start
        PageAdmin pageAdmin = new PageAdmin( 12, 1, 10);
        assertEquals( 12, pageAdmin.updatePosition( 1));
        assertEquals( 11, pageAdmin.updatePosition( 0));
        assertEquals( 13, pageAdmin.updatePosition( 2));

        assertEquals( 14, pageAdmin.updatePosition( 3));
        assertEquals( 15, pageAdmin.updatePosition( 4));
        assertEquals( 16, pageAdmin.updatePosition( 5));
        assertEquals( 17, pageAdmin.updatePosition( 6));
        assertEquals( 16, pageAdmin.updatePosition( 5));
        assertEquals( 15, pageAdmin.updatePosition( 4));
        assertEquals( 14, pageAdmin.updatePosition( 3));
        assertEquals( 13, pageAdmin.updatePosition( 2));
        assertEquals( 12, pageAdmin.updatePosition( 1));
        assertEquals( 11, pageAdmin.updatePosition( 10));
        assertEquals( 10, pageAdmin.getPage( 9));
        assertEquals( 12, pageAdmin.getPage( 11));
        assertEquals( 9, pageAdmin.updatePosition( 8));

//        assertEquals( 18, pageAdmin.updatePosition( 7));
//        assertEquals( 19, pageAdmin.updatePosition( 8));
//        assertEquals( 20, pageAdmin.updatePosition( 9));
//        assertEquals( 21, pageAdmin.updatePosition( 10));
//        assertEquals( 22, pageAdmin.updatePosition( 11));
//        assertEquals( 22, pageAdmin.updatePosition( 1));
//        assertEquals( 21, pageAdmin.getPage( 0));
//        assertEquals( 23, pageAdmin.getPage( 2));
//        assertEquals( 24, pageAdmin.updatePosition( 3));
    }

}