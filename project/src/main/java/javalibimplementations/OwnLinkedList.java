package javalibimplementations;

public class OwnLinkedList {
    Node head;

    /**
     * Method to insert a new node to list.
     * @param data
     */
    public void insert(int data) {

        Node newNode = new Node(data);
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    /**
     * Method to get the last node of the list.
     * @return value of the last node in the list
     */
    public int getLast() {
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        return head.data;
    }

}
