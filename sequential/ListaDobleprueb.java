package sequential;
import java.util.Iterator;
import java.util.Scanner;

public class ListaDobleprueb {
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    String[] list = input.split(" ");
    SinglyLinkedList<String> lista = new SinglyLinkedList<String>();
    for (int i = 0; i < list.length; i++) {
        lista.add(list[i]);
    }
    SinglyLinkedList<String> nuevaLista = new SinglyLinkedList<String>();

    while(!lista.isEmpty()){
        nuevaLista.add(lista.get(0));
        lista.remove(0);
        if(!lista.isEmpty()){
            nuevaLista.add(lista.get(lista.size()-1));
            lista.remove(lista.size()-1);
        }
    }
    System.out.println(nuevaLista.toString());
    scanner.close();
 }
}
class SinglyLinkedList<T> implements Iterable<T>{
    // Pointer to the first element in the list
    private Node<T> head;
    // Pointer to the last element in the list
    private Node<T> tail;
    // Property to count the quantity of the elements in the list
    private int size;
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
    
    /**
     * We initialize the list without elements, the value null indicate that there
     * is no elements in the list
     */
    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * We called the method to add by index, indicating that the element will be
     * added in
     * the size of the list, we did that in order to reuse the logic.
     * 
     * @param e element to be added at the end of the list
     */
    public void add(T e) {
        this.add(this.size, e);
    }

    /**
     * Add an element by index
     * 
     * @param index index where the element will be inserted
     * @param e     element to be inserted
     */
    public void add(int index, T e) {
        Node<T> newNode = new Node(e);
        // As we have two pointer we can categorize the insertion in three cases as
        // following:
        // 1. We insert in the beginning of the list
        // 2. We insert in the end of the list
        // 3. We insert between beginning and end of the list
        if (index == 0) { // Insert in the beginning
            newNode.setNext(this.head);
            this.head = newNode;
            // If it's the first element to be inserted we point the end pointer to
            // beginning of the list
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else if (index == this.size) { // Insert in the end
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else { // Insert between beginning and end
            Node<T> prev = this.head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            Node<T> current = prev.getNext();
            newNode.setNext(current);
            prev.setNext(newNode);
        }
        this.size++;
    }

    /**
     * Remove all the elements of the list
     * We reset the pointers to null and change the quantity of elements to zero.
     * as the memory is without references it will be cleaned up by the garbage
     * collector
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * We reuse the implemented logic by the indexOf method
     * 
     * @param e element to be search in the list
     * @return true if the element is inside the list, false otherwise
     */
    public boolean contains(T e) {
        return this.indexOf(e) != -1;
    }

    /**
     * Check if the index is valid, otherwise throw an exception
     * 
     * @param index index of the element to be returned
     * @return the element in a specific index
     */

    public T get(int index) {
        // As we are using two pointers we categorize the login in three cases as
        // following:
        // 1. If the index is zero we return the element referenced by the head pointer
        // 2. If the index is the last item in the list we return the element referenced
        // by the tail pointer
        // 3 If the index is between the beginning and end of the list
        if (index == 0)
            return this.head.getKey();
        if (index == this.size - 1)
            this.tail.getKey();
        Node<T> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getKey();
    }

    /**
     * We traverse from the head until we found the next pointer as null, which
     * indicate that we have reached
     * the end of the list.
     * 
     * @param e element to be searched in the list
     * @return the index of the element if it's found, otherwise return -1
     */
    public int indexOf(T e) {
        Node<T> node = this.head;
        int i = 0;
        while (node != null) {
            if (node.getKey().equals(e))
                return i;
            i++;
            node = node.getNext();
        }
        return -1;
    }

    /**
     *
     * @return true if the list is empty, otherwise return false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Remove a element by index
     * 
     * @param index of the element to be deleted
     * @return return the deleted element
     */
    public T remove(int index) {
        Node<T> temp;
        if (index == 0) {
            temp = this.head;
            this.head = this.head.getNext();
            if (this.head == null)
                this.tail = null;

        } else if (index == this.size - 1) {
            Node<T> pre = this.head;
            temp = pre.getNext();
            while (temp.getNext() != null) {
                pre = temp;
                temp = pre.getNext();
            }
            pre.setNext(null);
            this.tail = pre;
        } else {
            Node<T> pre = null;
            temp = this.head;
            for (int i = 0; i < index; i++) {
                pre = temp;
                temp = temp.getNext();
            }
            pre.setNext(temp.getNext());
        }
        this.size--;
        return temp.getKey();
    }


    public boolean remove(T e) {
        int index = this.indexOf(e);
        if (index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }

    /**
     *
     * @return a number indicate the size of the list
     */
    public int size() {
        return this.size;
    }

    /**
     *
     * @return iterator to be able of iterating the list with a foreach or while
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = SinglyLinkedList.this.head;

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

    /**
     *
     * @return String representation of the list
     */
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

}
