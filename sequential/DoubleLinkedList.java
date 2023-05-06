package sequential;

import util.NodeDouble;
import util.Util;
import java.util.Iterator;


// Profe todos funcionan bien menos el remove por index

public class DoubleLinkedList<T> implements List<T> {
    // Pointer to the first element in the list
    private NodeDouble<T> head;
    // Pointer to the last element in the list
    private NodeDouble<T> tail;
    // Property to count the quantity of the elements in the list
    private int size;

    public DoubleLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void add(T e) {
        this.add(this.size, e);
    }

    @Override
    public void add(int index, T e) {
        Util.checkIndexOpen(index, this.size);
        NodeDouble<T> newNode = new NodeDouble(e);

        if (index == 0) {
            newNode.setNext(this.head);
            newNode = this.head.getPrevious();
            this.head = newNode;
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else if (index == this.size) {
            NodeDouble temp = this.head;
            while (temp.getNext() != this.tail) {
                temp = temp.getNext();
            }
            this.head = newNode;
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else { // Insert between beginning and end
            NodeDouble<T> temporal = this.head;

            for (int i = 0; i < index - 1; i++) {
                temporal = temporal.getNext();
            }
            NodeDouble<T> current = temporal.getNext();
            newNode = temporal.getNext().getPrevious();
            newNode.setNext(current);
            temporal.setNext(newNode);
            newNode.setPrevious(temporal);
        }
        this.size++;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T e : this) {
            sb.append(e);
            sb.append(",");
        }
        if (sb.length() > 1)
            sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T e) {
        return this.indexOf(e) != -1;
    }

    @Override
    public T get(int index) {
        if (index == 0) {
            return this.head.getKey();
        }
        if (index == this.size - 1) {
            this.tail.getKey();
        }
        NodeDouble<T> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getKey();
    }

    @Override
    public int indexOf(T e) {
        NodeDouble<T> node = this.head;
        int i = 0;
        while (node != null) {
            if (node.getKey().equals(e))
                return i;
            i++;
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public boolean remove(T e) {
        int index = this.indexOf(e);
        if (index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodeDouble<T> node = DoubleLinkedList.this.head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T e = node.getKey();
                node = node.getNext();
                return e;
            }
        };
    }

}
