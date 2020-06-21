package Resit;

import java.util.*;

public class Solution3 {
    /**
     * @param list
     *     The singly linked list to sort.
     * @return A new singly linked list that contains the elements as the input list sorted in non-decreasing order.
     */
    static SLList insertionSort(SLList list) {
        if (list == null) return null;
        SLList sorted = new SLList();

        SLList.Node node = list.getFirst();
        while (node != null) {
            SLList.Node n = sorted.getFirst();

            if (n == null || n.getElement() > node.getElement()) {
                sorted.addFirst(node.getElement());
            } else {
                while (n != null && n.getNext() != null && n.getNext().getElement() < node.getElement()) {
                    n = n.getNext();
                }
                sorted.addAfter(n, node.getElement());
            }

            node = node.getNext();
        }

        return sorted;
    }
}

/**
 * Library
 */
class SLList {
    class Node {
        // Each Node object has these two fields
        private int element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(int e, Node n) {
            element = e;
            next = n;
        }

        // This function gets int e as input and sets e as the element of the Node
        public void setElement(int e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public int getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    public SLList(int... elements) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int element : elements) {
            reversed.add(element);
        }
        while (!reversed.isEmpty()) {
            this.addFirst(reversed.removeLast());
        }
    }

    /**
     * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
     */
    public Node getFirst() {
        if (head == null)
            return null;
        return head;
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(int e) {
        head = new Node(e, head);
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node.
     * @throws NullPointerException
     *     If the list is empty.
     */
    public int removeFirst() {
        Node result = head;
        head = head.getNext();
        return result.getElement();
    }

    /**
     * Adds an element after an already existing node.
     *
     * @param node
     *     The node to add a new element after.
     * @param e
     *     The new element to add.
     */
    public void addAfter(Node node, int e) {
        Node newNode = new Node(e, node.getNext());
        node.setNext(newNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SLList slList = (SLList) o;
        Node a = this.head;
        Node b = slList.head;
        while (a != null && b != null) {
            if (!Objects.equals(a.getElement(), b.getElement())) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return Objects.equals(a, b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SLList[");
        Node current = this.head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(",");
            current = current.next;
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }
}
