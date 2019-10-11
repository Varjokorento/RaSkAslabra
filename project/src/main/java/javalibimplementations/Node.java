package javalibimplementations;

public class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
