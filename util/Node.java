package util;

/**
 * Utility class to build a single linked list, the next property is a pointer to next
 * element in the list
 * @author Andres Gutierrez
 * @param <T> Type of the data to store
 */
public class Node<T> {
    //Property which store the value of a specific element in the list
    private T key;
    //Property which store a pointer to the following element in the list
    private Node<T> next;

    public Node(T key) {
        this.key = key;
        next = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
