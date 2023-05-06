package util;

public class NodeDouble<T> {
    // Property which store the value of a specific element in the list
    private T key;
    // Property which store a pointer to the following element in the list
    private NodeDouble<T> next;
    // Property which store a pointer to the preview element in the list bn
    private NodeDouble<T> previous;

    public NodeDouble(T key) {
        this.key = key;
    }

    public NodeDouble(T key, NodeDouble<T> next, NodeDouble<T> previous) {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    public NodeDouble<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDouble<T> previous) {
        this.previous = previous;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

}
