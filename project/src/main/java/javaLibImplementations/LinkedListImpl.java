package javaLibImplementations;

public class LinkedListImpl {
    Node head;

    /**
     * Method to insert a new node to list.
     * @param data
     */
    public void insert(int data)
    {

        Node new_node = new Node(data);
        new_node.next = null;

        if (this.head == null) {
            this.head = new_node;
        }

        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    /**
     * Method to get the last node of the list.
     * @return value of the last node in the list
     */
    public int getLast() {
        Node head = this.head;
        while(head.next != null) {
            head = head.next;
        }
        return head.data;
    }

}
