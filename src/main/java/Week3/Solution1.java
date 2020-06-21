package Week3;

import java.util.*;

/**
 * Interface for a Queue.
 * <p>
 * DO NOT MODIFY
 *
 * @param <T> Type of elements the queue can hold
 */
interface QueueInterface<T> {
  /**
   * @return true iff it contains no elements.
   */
  public boolean isEmpty();

  /**
   * @return the number of elements in the queue.
   */
  public int size();

  /**
   * Add an element to the end of the queue
   *
   * @param e element to add.
   */
  public void enqueue(T e);

  /**
   * Removes the first element from the queue.
   *
   * @return the first element.
   * @throws NoSuchElementException iff the queue is empty
   */
  public T dequeue() throws NoSuchElementException;

  /**
   * @return the first element (does not remove it).
   * @throws NoSuchElementException iff the queue is empty
   */
  public T front() throws NoSuchElementException;
}

abstract class MyQueue<T> implements QueueInterface<T> {
  /**
   * Reverses the queue itself. NB: This method should be recursive.
   */
  public void reverse() {
    if (size() <= 1) return;
    reverse(size(), dequeue());
  }

  /**
   * Reverses the queue itself.
   *
   * @param n       The input size n
   * @param element The first dequeued element
   */
  public int reverse(int n, T element) {
    if (n <= 0) return 0;
    T el = (n - 1 <= 0) ? null : dequeue();
    int r = reverse(n - 1, el);
    enqueue(element);
    return r;
  }
}
