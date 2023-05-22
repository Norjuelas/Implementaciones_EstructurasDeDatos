import nonSequential.*;

public class Main{
    
    public static void main(String[] args) {

        IterativeBinarySearchTree<Integer> bst = new IterativeBinarySearchTree<>();
        bst.insert(30);
        bst.insert(15);
        bst.insert(10);
        bst.insert(26);
        bst.insert(45);
        bst.insert(32);
        bst.insert(46);
        bst.insert(48);
        bst.inOrder();
        System.out.println("/n");
        bst.preOrder();
        System.out.println("/n");
        bst.postOrder();
        System.out.println("/n");
        System.out.println(bst.search(48));
        System.out.println(bst.search(7));
        System.out.println("/n");
        System.out.println(bst.maxValue() + " " + bst.minValue()+" "+bst.size()+" "+bst.height());
        System.out.println("/n");
        bst.delete(32);
        System.out.println("/n");
        System.out.println(bst.search(32));
        bst.inOrder();

    }
}
