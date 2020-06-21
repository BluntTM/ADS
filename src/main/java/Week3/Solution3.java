package Week3;

import java.util.*;

/**
 * DO NOT MODIFY
 * Interface for a Stack.
 *
 * @param <T> Type of elements the Stack can hold
 */
interface Stack<T> {
  /**
   * @return true iff it contains no elements.
   */
  public boolean isEmpty();

  /**
   * @return the number of elements in the stack.
   */
  public int size();

  /**
   * Add an element to the top of the stack
   *
   * @param e element to push.
   */
  public void push(T e);

  /**
   * Removes the top element from the stack.
   *
   * @return the first element.
   * @throws NoSuchElementException iff the stack is empty
   */
  public T pop() throws NoSuchElementException;

  /**
   * @return the top element (does not pop it).
   * @throws NoSuchElementException iff the stack is empty
   */
  public T peek() throws NoSuchElementException;
}

class Queue<T> {
  private Stack<T> s1 = new LibraryStack<>();
  private Stack<T> s2 = new LibraryStack<>();

  /**
   * @return true iff there are no elements left.
   */
  public boolean isEmpty() {
    return s1.isEmpty() && s2.isEmpty();
  }

  /**
   * @return the number of elements in the queue.
   */
  public int size() {
    return s1.size() + s2.size();
  }

  /**
   * Helper method which moves a Stack to another stack
   *
   * @param from The initial stack to move the items from
   * @param to   The stack to move the items to
   */
  private void move(Stack<T> from, Stack<T> to) {
    List<T> list = new ArrayList<>();
    while (from.size() > 0) {
      list.add(from.pop());
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      to.push(list.get(i));
    }
  }

  /**
   * Adds an element to the queue.
   *
   * @param i element to enqueue.
   */
  public void enqueue(T i) {
    if (size() % 2 == 0) {
      s1.push(i);
      move(s2, s1);
    } else {
      s2.push(i);
      move(s1, s2);
    }
  }

  /**
   * Removes the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException iff the queue is empty.
   */
  public T dequeue() throws NoSuchElementException {
    if (size() == 0) throw new NoSuchElementException();
    if (size() % 2 == 0) {
      move(s2, s1);
      return s1.pop();
    } else {
      move(s1, s2);
      return s2.pop();
    }
  }

  /**
   * Only returns (i.e. does not remove) the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException iff the queue is empty.
   */
  public T first() throws NoSuchElementException {
    if (size() == 0) throw new NoSuchElementException();
    if (size() % 2 == 0) {
      return s2.peek();
    } else {
      return s1.peek();
    }
  }
}

/**
 * Library
 */
class LibraryStack<T> implements Stack<T> {
  private LinkedList<T> ll;

  public LibraryStack() {
    ll = new LinkedList<>();
  }

  /**
   * @return true iff the stack is empty, else false
   */
  public boolean isEmpty() {
    return ll.isEmpty();
  }

  /**
   * @return amount of elements in stack
   */
  public int size() {
    return ll.size();
  }

  /**
   * Pushes a new element to the stack.
   *
   * @param e element to be added to the stack
   */
  public void push(T e) {
    ll.offer(e);
  }

  /**
   * Removes top element from the stack and returns it.
   *
   * @return top element of the stack
   * @throws NoSuchElementException iff the stack is empty
   */
  public T pop() throws NoSuchElementException {
    return ll.removeLast();
  }

  /**
   * Returns the top element of the stack, without removing it.
   *
   * @return top element of the stack
   * @throws NoSuchElementException iff the stack is empty
   */
  public T peek() throws NoSuchElementException {
    if (ll.peekLast() == null) {
      throw new NoSuchElementException();
    }
    return ll.peekLast();
  }
}
