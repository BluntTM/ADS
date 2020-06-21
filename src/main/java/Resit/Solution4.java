package Resit;

class ArrayBasedStack {
    public Object[] stack;
    public int size;

    /**
     * The constructor of the ArrayBasedStack.
     *
     * @param capacity
     *     Maximum number of items that can be stored in the stack.
     */
    public ArrayBasedStack(int capacity) {
        this.stack = new Object[capacity];
        this.size = 0;
    }

    /**
     * Push an item to the stack.
     *
     * @param o
     *     Object that is pushed on the stack.
     * @return the object, iff the object has been pushed to stack successfully.
     * Returns null, if the object cannot be pushed to the stack.
     */
    public Object push(Object o) {
        if (size >= stack.length) return null;
        stack[size++] = o;
        return o;
    }

    /**
     * Pops the first item from the stack.
     *
     * @return the object, iff the object has been popped from stack successfully. Null, if the stack is empty.
     */
    public Object pop() {
        if (size == 0) return null;
        return stack[--size];
    }

    /**
     * Check the item on top of the stack, without removing it.
     *
     * @return the top object, iff the stack has an item. Null, if the stack is empty.
     */
    public Object peek() {
        if (size == 0) return null;
        return stack[size - 1];
    }
}
