package Week2;

class DLList {
    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;
    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        if (head == null) return null;
        return head.getElement();
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        if (tail == null) return null;
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        if (head == null) {
            Node n = new Node(e, null, null);
            head = n;
            tail = n;
        } else {
            Node n = new Node(e, null, head);
            if (head == tail) {
                head = n;
                tail.previous = n;
            } else {
                head.previous = n;
                head = n;
            }
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (head != null) {
            if (head == tail) {
                Object el = head.element;
                head = null;
                tail = null;
                return el;
            }

            Object el = head.element;
            head = head.next;
            head.setPrevious(null);
            return el;
        }
        return null;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e The element to add.
     */
    public void addLast(Object e) {
        if (tail == null) {
            Node n = new Node(e, null, null);
            tail = n;
            head = n;
        } else {
            Node n = new Node(e, tail, null);
            tail.next = n;
            tail = n;
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (tail != null) {
            if (head == tail) {
                Object el = head.element;
                head = null;
                tail = null;
                return el;
            }

            Object el = tail.element;
            tail = tail.previous;
            tail.setNext(null);
            return el;
        }
        return null;
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if (head == null && tail == null) return 0;
        if (head == tail) return 1;

        int count = 0;
        Node c = head;
        while (c != null) {
            count++;
            c = c.next;
        }
        return count;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos The position to insert the element at.
     * @param e   The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (pos == 0) {
            addFirst(e);
        } else if (pos < 0 || pos >= size()) {
            addLast(e);
        } else {
            Node node = head;
            while (pos > 0) {
                node = node.next;
                pos--;
            }

            Node n = new Node(e, node.previous, node);
            node.previous.next = n;
            node.previous = n;
        }
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos < 0 || pos >= size()) return null;
        if (pos == 0) return removeFirst();
        if (pos == size() - 1) return removeLast();

        Node n = head;
        while (pos > 0) {
            n = n.next;
            pos--;
        }

        n.previous.next = n.next;
        n.next.previous = n.previous;
        return n.element;
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {
        DLList list = new DLList();

        Node next = head;
        for (int i = 0; i < size(); i++) {
            list.addFirst(next.element);
            next = next.next;
        }

        return list;
    }

    class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
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

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }
    }
}
