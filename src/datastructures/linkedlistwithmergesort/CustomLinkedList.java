package src.datastructures.linkedlistwithmergesort;

import java.util.*;

/**
 * Class KWLinkedList implements a double linked list and
 * a ListIterator.
 * 
 * @author Group 2
 */
public class CustomLinkedList<E extends Comparable<E>> implements Iterable<E> {
  /** Starting point of the linked list */
  private Node<E> head = null;
  /** Ending point of the linked list */
  private Node<E> tail = null;
  /** Size of the linked list */
  private int size = 0;

  
  /** 
   * Wrapper for sorting the nodes in an increasing order
   * @return CustomLinkedList<E> ordered linkedlist
   */
  public CustomLinkedList<E> mergeSort() {
    this.head = this.mergeSort(this.head);

    return this;
  }

  
  /** 
   * Merge sort algorithm for the given linkedlist
   * @param aNode middle index node for dicing
   * @return Node<E> sorted lists head
   */
  private Node<E> mergeSort(Node<E> aNode) {
    // Base case : if head is null
    if (aNode == null || aNode.next == null) {
      return aNode;
    }

    // get the middle of the list
    Node<E> middle = getMiddle(aNode);
    Node<E> nextofmiddle = middle.next;

    // set the next of middle node to null
    middle.next = null;

    // Apply mergeSort on left list
    Node<E> left = mergeSort(aNode);

    // Apply mergeSort on right list
    Node<E> right = mergeSort(nextofmiddle);

    // Merge the left and right lists
    Node<E> sortedlist = sortedMerge(left, right);
    return sortedlist;
  }

  
  /** 
   * Returns the middle of the between given head and last node
   * @param head head node of the sub linked list
   * @return Node<E> next head of the sub linked list
   */
  // Utility function to get the middle of the linked list
  public Node<E> getMiddle(Node<E> head) {
    if (head == null) return head;

    Node<E> slow = head, fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  
  /** 
   * Merging two nodes in a increased order
   * @param a merge element
   * @param b merge element
   * @return Node<E> returns the sorted sub linked list
   */
  Node<E> sortedMerge(Node<E> a, Node<E> b) {
    Node<E> result = null;
    /* Base cases */
    if (a == null) return b;
    if (b == null) return a;

    /* Pick either a or b, and recur */
    if (a.data.compareTo(b.data) <= 0) {
      result = a;
      result.next = sortedMerge(a.next, b);
    } else {
      result = b;
      result.next = sortedMerge(a, b.next);
    }
    return result;
  }

  
  /** 
   * Getter for the size
   * @return int returns the of linked list
   */
  public int size() {
    return size;
  }

  
  /**
   * Remove method for the given item 
   * @param item item to be deleted
   * @return E returns item if successful, other wise returns tail
   */
  public E remove(E item) {
    Iterator<E> iter = iterator();
    E removedItem = null;
    while (iter.hasNext()) {
      removedItem = iter.next();

      if (removedItem.compareTo(item) == 0) {
        iter.remove();
        break;
      }
    }
    return removedItem;
  }

  
  /** 
   * Adding the given item to the linked list
   * @param item item to be added
   */
  public void add(E item) {
    add(size, item);
  }

  /**
   * Insert an object at the beginning of the list.
   *
   * @param item - the item to be added
   */
  public void addFirst(E item) {
    add(0, item);
  }

  /**
   * Insert an object at the end of the list.
   *
   * @param item - the item to be added
   */
  public void addLast(E item) {
    add(size, item);
  }

  /**
   * Get the first element in the list.
   *
   * @return The first element in the list.
   */
  public E getFirst() {
    return head.data;
  }

  /**
   * Get the last element in the list.
   *
   * @return The last element in the list.
   */
  public E getLast() {
    return tail.data;
  }

  /**
   * Return an Iterator to the list
   *
   * @return an Itertor tot the list
   */
  public Iterator<E> iterator() {
    return new KWListIter(0);
  }

  /**
   * Return a ListIterator to the list
   *
   * @return a ListItertor to the list
   */
  public ListIterator<E> listIterator() {
    return new KWListIter(0);
  }

  /**
   * Return a ListIterator that begins at index
   *
   * @param index - The position the iteration is to begin
   * @return a ListIterator that begins at index
   */
  public ListIterator<E> listIterator(int index) {
    return new KWListIter(index);
  }

  /**
   * Add an item at the specified index.
   *
   * @param index The index at which the object is to be
   *              inserted
   * @param obj   The object to be inserted
   * @throws IndexOutOfBoundsException if the index is out
   *                                   of range (i < 0 || i > size())
   */
  public void add(int index, E obj) {
    listIterator(index).add(obj);
  }

  /**
   * Get the element at position index.
   *
   * @param index Position of item to be retrieved
   * @return The item at index
   */
  public E get(int index) {
    return listIterator(index).next();
  }

  /**
   * Node representation class of the linked list
   */
  private static class Node<E> {

    /** The data value. */
    private E data;

    /** The link to the next node. */
    private Node<E> next = null;

    /** The link to the previous node. */
    private Node<E> prev = null;

    /**
     * Construct a node with the given data value.
     *
     * @param dataItem The data value
     */
    private Node(E dataItem) {
      data = dataItem;
    }
  } // end class Node

  /** Inner class to implement the ListIterator interface. */
  private class KWListIter implements ListIterator<E> {

    /** A reference to the next item. */
    private Node<E> nextItem;

    /** A reference to the last item returned. */
    private Node<E> lastItemReturned;

    /** The index of the current item. */
    private int index = 0;

    /**
     * Construct a KWListIter that will reference the ith item.
     *
     * @param i The index of the item to be referenced
     */
    public KWListIter(int i) {
      // Validate i parameter.
      if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException("Invalid index " + i);
      }
      lastItemReturned = null; // No item returned yet.
      // Special case of last item.
      if (i == size) {
        index = size;
        nextItem = null;
      } else { // Start at the beginning
        nextItem = head;
        for (index = 0; index < i; index++) {
          nextItem = nextItem.next;
        }
      }
    }

    /**
     * Indicate whether movement forward is defined.
     *
     * @return true if call to next will not throw an exception
     */
    public boolean hasNext() {
      return nextItem != null;
    }

    /**
     * Move the iterator forward and return the next item.
     *
     * @return The next item in the list
     * @throws NoSuchElementException if there is no such object
     */
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastItemReturned = nextItem;
      nextItem = nextItem.next;
      index++;
      return lastItemReturned.data;
    }

    /**
     * Indicate whether movement backward is defined.
     *
     * @return true if call to previous will not throw an exception
     */
    public boolean hasPrevious() {
      return (nextItem == null && size != 0) || nextItem.prev != null;
    }

    /**
     * Return the index of the next item to be returned by next
     *
     * @return the index of the next item to be returned by next
     */
    public int nextIndex() {
      return index;
    }

    /**
     * Return the index of the next item to be returned by previous
     *
     * @return the index of the next item to be returned by previous
     */
    public int previousIndex() {
      return index - 1;
    }

    /**
     * Move the iterator backward and return the previous item.
     *
     * @return The previous item in the list
     * @throws NoSuchElementException if there is no such object
     */
    public E previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      if (nextItem == null) { // Iterator past the last element
        nextItem = tail;
      } else {
        nextItem = nextItem.prev;
      }
      lastItemReturned = nextItem;
      index--;
      return lastItemReturned.data;
    }

    /**
     * Add a new item between the item that will be returned
     * by next and the item that will be returned by previous.
     * If previous is called after add, the element added is
     * returned.
     *
     * @param obj The item to be inserted
     */
    public void add(E obj) {
      if (head == null) { // Add to an empty list.
        head = new Node<E>(obj);
        tail = head;
      } else if (nextItem == head) { // Insert at head.
        // Create a new node.
        Node<E> newNode = new Node<E>(obj);
        // Link it to the nextItem.
        newNode.next = nextItem; // Step 1
        // Link nextItem to the new node.
        nextItem.prev = newNode; // Step 2
        // The new node is now the head.
        head = newNode; // Step 3
      } else if (nextItem == null) { // Insert at tail.
        // Create a new node.
        Node<E> newNode = new Node<E>(obj);
        // Link the tail to the new node.
        tail.next = newNode; // Step 1
        // Link the new node to the tail.
        newNode.prev = tail; // Step 2
        // The new node is the new tail.
        tail = newNode; // Step 3
      } else { // Insert into the middle.
        // Create a new node.
        Node<E> newNode = new Node<E>(obj);
        // Link it to nextItem.prev.
        newNode.prev = nextItem.prev; // Step 1
        nextItem.prev.next = newNode; // Step 2
        // Link it to the nextItem.
        newNode.next = nextItem; // Step 3
        nextItem.prev = newNode; // Step 4
      }
      // Increase size and index and set lastItemReturned.
      size++;
      index++;
      lastItemReturned = null;
    } // End of method add.

    /**
     * Remove the last item returned. This can only be
     * done once per call to next or previous.
     *
     * @throws IllegalStateException if next or previous
     *                               was not called prior to calling this method
     */
    /**** BEGIN EXERCISE ****/
    public void remove() {
      if (lastItemReturned == null) {
        throw new IllegalStateException();
      }
      // Unlink this item from its next neighbor
      if (lastItemReturned.next != null) {
        lastItemReturned.next.prev = lastItemReturned.prev;
      } else { // Item is the tail
        tail = lastItemReturned.prev;
        if (tail != null) {
          tail.next = null;
        } else { // list is now empty
          head = null;
        }
      }
      // Unlink this item from its prev neighbor
      if (lastItemReturned.prev != null) {
        lastItemReturned.prev.next = lastItemReturned.next;
      } else { // Item is the head
        head = lastItemReturned.next;
        if (head != null) {
          head.prev = null;
        } else {
          tail = null;
        }
      }
      // Invalidate lastItemReturned
      lastItemReturned = null;
      // decrement both size and index
      size--;
      index--;
    }

    /**
     * Replace the last item returned with a new value
     *
     * @param item The new value
     * @throws IllegalStateException if next or previous
     *                               was not called prior to calling this method
     */
    public void set(E item) {
      if (lastItemReturned == null) {
        throw new IllegalStateException();
      }
      lastItemReturned.data = item;
    }
    /**** END EXERCISE ****/

  } // end class KWListIter
}
