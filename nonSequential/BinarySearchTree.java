package nonSequential;

public interface BinarySearchTree<T extends Comparable<T>> {
    boolean search(T data);//
    void insert(T data);//
    void delete(T data);
    void inOrder();
    void preOrder();
    void postOrder();
    int height();
    int size();
    T minValue();
    T maxValue();
    boolean isBalanced();
    void balance();
}
