package nonSequential;

import sequential.ArrayList;
import sequential.List;
import util.TreeNode;


public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    protected TreeNode<T> root;

    public RecursiveBinarySearchTree(T data) {
        this.root = new TreeNode<>(data);
    }

    public RecursiveBinarySearchTree() {
        this.root = null;
    }

    @Override
    public boolean search(T data) {
        return this.search(this.root, data) != null;
    }

    @Override
    public void insert(T data) {
       this.root = this.insert(this.root, data);
    }

    @Override
    public void delete(T data) {
        this.root = this.delete(this.root, data);
    }

    @Override
    public void inOrder() {
        this.inOrder(this.root);
    }

    @Override
    public void preOrder() {
        this.preOrder(this.root);
    }

    @Override
    public void postOrder() {
        this.postOrder(this.root);
    }

    @Override
    public int height() {
        return this.height(this.root);
    }

    @Override
    public int size() {
        return this.size(root);
    }

    @Override
    public T minValue() {
        return this.minValue(this.root);
    }

    @Override
    public T maxValue() {
       return this.maxValue(this.root);
    }

    @Override
    public boolean isBalanced() {
        return this.isBalanced(root);
    }

    @Override
    public void balance() {
        List<T> values = new ArrayList<>();
        this.inOrder(root, values);
        this.buildTree(values);
    }

    private void buildTree(List<T> values) {
        this.root = buildTreeUtil(0, values.size() - 1, values);
    }

    private TreeNode<T> buildTreeUtil(int start, int end, List<T> values) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode<T> rootn = new TreeNode<>(values.get(mid));
        rootn.setLeft(this.buildTreeUtil(start, mid-1, values));
        rootn.setRight(this.buildTreeUtil(mid+1,end,values));
        return rootn;
    }

    private void inOrder(TreeNode<T> root, List<T> values) {
        if(root == null) return;
        this.inOrder(root.getLeft(), values);
        values.add(root.getKey());
        this.inOrder(root.getRight(), values);
    }


    private TreeNode<T> delete(TreeNode<T> root, T data) {
        if(root == null) return root;
        if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.delete(root.getLeft(), data));
        }
        else if (data.compareTo(root.getKey()) > 0) {
            root.setRight(this.delete(root.getRight(), data));
        }
        else {
            if(root.getLeft() == null) return root.getRight();
            else if(root.getRight() == null) return root.getLeft();
            root.setKey(this.minValue(root.getRight()));
            root.setRight(delete(root.getRight(), root.getKey()));
        }
        return root;
    }

    private int size(TreeNode<T> root) {
        if(root == null)  return 0;
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    protected int height(TreeNode<T> root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    protected T minValue(TreeNode<T> root) {
        if(root == null) return null;
        if(root.getLeft() == null) return root.getKey();
        else return minValue(root.getLeft());
    }

    private T maxValue(TreeNode<T> root) {
        if(root == null) return null;
        if(root.getRight() == null) return root.getKey();
        else return maxValue(root.getRight());
    }

    private void inOrder(TreeNode<T> root) {
        if(root == null) return;
        this.inOrder(root.getLeft());
        System.out.print(root.getKey() + " ");
        this.inOrder(root.getRight());
    }

    private void preOrder(TreeNode<T> root) {
        if(root == null) return;
        System.out.print(root.getKey() + " ");
        this.inOrder(root.getLeft());
        this.inOrder(root.getRight());
    }

    private void postOrder(TreeNode<T> root) {
        if(root == null) return;
        this.inOrder(root.getLeft());
        this.inOrder(root.getRight());
        System.out.print(root.getKey() + " ");
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null) root = new TreeNode<>(data);
        else if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }
        return root;
    }

    private T search(TreeNode<T> root, T data) {
        if(root == null) return null;
        if(root.getKey().compareTo(data) == 0) {
            return root.getKey();
        }
        else if(data.compareTo(root.getKey()) < 0) {
            return this.search(root.getLeft(),data);
        }
        else return this.search(root.getRight(), data);
    }

    protected boolean isBalanced(TreeNode<T> root) {
        if(root == null) return true;
        int lh = this.height(root.getLeft());
        int rh = this.height(root.getRight());
        if(Math.abs(lh - rh) > 1) return false;
        return this.isBalanced(root.getLeft()) && this.isBalanced(root.getRight());
    }

}
