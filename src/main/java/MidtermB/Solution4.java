package MidtermB;

class CSLList<T> {
    // Each object in CSLList has one field tail, which points to the tail Node of CSLList.
    private Node tail;

    /**
     * Constructor: initialises the tail field as null
     */
    public CSLList() {
        tail = null;
    }

    /**
     * @return The element in the first Node of this CSLL. If the list is empty, this method returns null.
     */
    public T getFirst() {
        if (tail == null)
            return null;
        return tail.getNext().getElement();
    }

    /**
     * @return The element in the last Node of this CSLL. If the list is empty, this method returns null.
     */
    public T getLast() {
        if (tail == null)
            return null;
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(T e) {
        if (tail == null) {
            Node n = new Node(e, null);
            n.setNext(n);
            tail = n;
        } else {
            Node head = tail.next;
            tail.next = new Node(e, head);
        }
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e The element to add.
     */
    public void addLast(T e) {
        addFirst(e);
        tail = tail.next;
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node. If the list is empty, this method returns null.
     */
    public T removeFirst() {
        if (tail == null) return null;

        Node head = tail.next;
        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        return head.getElement();
    }

    /**
     * Rotates the list such that the second element in the list will become the first element in the list.
     * Example: rotating the list [1, 2, 3] will become [2, 3, 1].
     */
    public void rotate() {
        if (tail == null) return;
        tail = tail.next;
    }

    /**
     * Merges this list and the other list by alternating elements from the two lists.
     * If one of the lists is longer than the other, the remaining elements are added to the end of the resulting list.
     *
     * @param other The other list to alternate elements with. Is treated as an empty list if it is null.
     * @return A new list with alternated elements of this list and the other list.
     */
    public CSLList<T> alternate(CSLList<T> other) {
        if (other == null || other.tail == null) {
            return this;
        }

        if (tail == null) {
            return other;
        }

        CSLList<T> list = new CSLList<>();

        Node n1 = tail;
        Node n2 = other.tail;

        do {
            n1 = n1.next;
            n2 = n2.next;

            list.addLast(n1.getElement());
            list.addLast(n2.getElement());
        } while (n1 != tail && n2 != other.tail);

        while (n1 != tail) {
            n1 = n1.next;
            list.addLast(n1.getElement());
        }

        while (n2 != other.tail) {
            n2 = n2.next;
            list.addLast(n2.getElement());
        }

        return list;
    }

    public int size() {
        if (tail == null) return 0;
        int i = 0;
        Node n = tail;
        do {
            n = n.next;
            i++;
        } while (n != tail);
        return i;
    }

    /**
     * Removes all elements at the odd positions in this list.
     * Note that the head of the list is element number 0, which is an even position.
     */
    public void dropOdd() {
        if (tail == null || tail == tail.next) return;

        if (size() % 2 == 0) {
            // remove odds
            Node head = tail.next;
            do {
                head.next = head.next.next;
                head = head.next;
            } while (head != tail.next);

            // set tail to last
            Node head2 = tail.next;
            do {
                head2 = head2.next;
            } while (head2.next != tail.next);
            tail = head2;
        } else {
            // remove odds
            Node head = tail.next;
            while (head.next.next != tail.next) {
                head.next = head.next.next;
                if (head.next == tail) break;
                head = head.next;
            }
        }
    }

    class Node {
        // Each Node object has these two fields
        private T element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(T e, Node n) {
            element = e;
            next = n;
        }

        // This function returns the element variable of the Node
        public T getElement() {
            return element;
        }

        // This function gets T e as input and sets e as the element of the Node
        public void setElement(T e) {
            element = e;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }
    }
}