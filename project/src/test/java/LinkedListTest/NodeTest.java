package linkedlisttest;

import javalibimplementations.Node;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class NodeTest {

    private Node node = new Node(1);

    @Test
    public void newNodeHasNONeighbour() {
        Node newNode = node.getNext();
        assertNull(newNode);
    }

    @Test
    public void neighbourCanBeSetToNode() {
        Node neighbour = new Node(2);
        node.setNext(neighbour);
        Node shouldBeNeighbour = node.getNext();
        assertEquals(neighbour, shouldBeNeighbour);
    }
}
