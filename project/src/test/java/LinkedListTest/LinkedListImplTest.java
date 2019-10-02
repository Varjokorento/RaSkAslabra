package LinkedListTest;

import javaLibImplementations.LinkedListImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinkedListImplTest {
    LinkedListImpl linkedList = new LinkedListImpl();

    @Test
    public void insertToLinkedListWorks() {
        linkedList.insert(2);
        assertEquals(2, linkedList.getLast());
    }

    @Test
    public void getLastGetsTheLastNodeInTheList() {
        linkedList.insert(2);
        linkedList.insert(3);
        assertEquals(3, linkedList.getLast());
        linkedList.insert(4);
        assertEquals(4, linkedList.getLast());
    }
}
