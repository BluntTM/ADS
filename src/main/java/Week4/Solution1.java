package Week4;

class ArrayStack {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStack() {
        this.size = 0;
        this.capacity = 1;
        this.elements = new Object[this.capacity];
    }

    /**
     * @return The size of this ArrayStack.
     */
    public int size() {
        return size;
    }

    /**
     * @return `true` iff this ArrayStack is empty, `false` otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return `true` iff the size is equal to the capacity, `false` otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    private void resize(int size) {
        Object[] newArr = new Object[size];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = this.elements[i];
        }
        this.elements = newArr;
        this.capacity = size;
    }

    /**
     * @return the top element of the stack without removing it
     */
    public Object peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return elements[size - 1];
    }

    /**
     * Adds `o` to the stack.
     * If capacity of stack was too small, capacity is doubled and `o` is added.
     *
     * @param o the element to add to the stack.
     */
    public void push(Object o) {
        if (isFull())
            resize(capacity * 2);

        elements[size++] = o;
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException iff the queue is empty
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object ret = elements[--size];

        if ((double) size / capacity < 0.25)
            if (capacity / 2 > 0)
                resize(capacity / 2);

        return ret;
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("<ArrayStack[");
        String end = "]>(Size=" + size + ", Cap=" + capacity + ")";

        for (int i = 0; i < size; i++) {
            Object o = elements[i];
            builder.append(o);

            if (i < size - 1) {
                builder.append(",");
            }
        }

        return builder.append(end).toString();
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}

/**
 * Library
 */
class EmptyStackException extends Exception {
    private static final long serialVersionUID = -8010862139713793776L;

    public EmptyStackException() {
        super("Stack is empty");
    }
}


