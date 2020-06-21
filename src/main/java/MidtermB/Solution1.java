package MidtermB;

import java.util.*;

class Solution1 {
    /**
     * Checks for a String represented as a SLList whether this String is a palindrome.
     * This is done by using a queue.
     * <p>
     * An empty String or null should return true.
     *
     * @param list SLList used to represent a String
     * @return true if the String represented as a SLList is a palindrome, otherwise false
     */
    public static boolean checkPalindrome(SLList list) {
        if (list == null || list.size() == 1) return true;
        LibraryQueue<Entry> queue = new LibraryQueue<>();

        int size = list.size();
        int middle = size / 2;
        boolean even = size % 2 == 0;
        if (!even) {
            middle += 1;
        }

        for (int i = 0; i < middle; i++)
            queue.enqueue(new Entry(i, list.removeFirst()));

        while (queue.size() > 0) {
            if (!even) {
                queue.dequeue();
                even = true;
            }

            if (!list.removeFirst().equals(queue.dequeue().getElement()))
                return false;
        }

        return true;
    }
}

/**
 * Library
 */
class LibraryQueue<T> {
    private PriorityQueue<T> ll;

    public LibraryQueue() {
        ll = new PriorityQueue<>();
    }

    /**
     * @return true iff the priority queue is empty, else false
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * @return amount of elements in the priority queue
     */
    public int size() {
        return ll.size();
    }

    /**
     * Adds an Entry to the priority queue sorted on the key in a decreasing order.
     *
     * @param e Entry to be added.
     */
    public void enqueue(T e) {
        ll.offer(e);
    }

    /**
     * Removes the Entry with the maximum key from the priority queue.
     *
     * @return Entry with max key in pq
     * @throws NoSuchElementException iff this queue is empty
     */
    public T dequeue() throws NoSuchElementException {
        return ll.remove();
    }

    /**
     * Returns the Entry with the maximum key from the priority queue,
     * without removing it.
     *
     * @return Entry with max key in pq
     * @throws NoSuchElementException iff this queue is empty
     */
    public T front() throws NoSuchElementException {
        if (ll.peek() == null) {
            throw new NoSuchElementException();
        }
        return ll.peek();
    }
}

class Entry implements Comparable<Entry> {
    private int key;
    private char element;

    public Entry(int key, char element) {
        this.key = key;
        this.element = element;
    }

    public int getKey() {
        return this.key;
    }

    public char getElement() {
        return this.element;
    }

    @Override
    public int compareTo(Entry other) {
        // Used to sort the entries in descending order
        return other.getKey() - this.getKey();
    }
}

class SLList {
    private LinkedList<Character> ll;

    /**
     * Creates a new SLList with a String, each character will be a node.
     * The first character in the String will be the head.
     *
     * @param s String that this SLList represents.
     */
    public SLList(String s) {
        ll = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            ll.addFirst(s.charAt(i));
        }
    }

    /**
     * Removes the first element in the list and returns it.
     *
     * @return first element in the list
     */
    public Character removeFirst() {
        return ll.poll();
    }

    /**
     * Returns the first element in the first and returns it, without removing it.
     *
     * @return first element in the list
     */
    public Character getFirst() {
        return ll.peek();
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return ll.size();
    }
}