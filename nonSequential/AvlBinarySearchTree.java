package nonSequential;

import util.TreeNode;

public class AvlBinarySearchTree<T extends Comparable<T>> extends RecursiveBinarySearchTree<T> {

    @Override
    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }

    @Override
    public void delete(T data) {
        this.root = this.delete(this.root, data);
    }

    @Override
    public void balance() {
        throw new RuntimeException("Not implemented");
    }

    private TreeNode<T> rotateLeft(TreeNode<T> root) {
        TreeNode<T> x = root.getRight();
        TreeNode<T> z = x.getLeft();
        x.setLeft(root);
        root.setRight(z);
        return x;
    }

    private TreeNode<T> rotateRight(TreeNode<T> root) {
        TreeNode<T> x = root.getLeft();
        TreeNode<T> z = x.getRight();
        x.setRight(root);
        root.setLeft(z);
        return x;
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null) root = new TreeNode<>(data);
        else if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }
        return reBalance(root);
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
        return reBalance(root);
    }

    private TreeNode<T> reBalance(TreeNode<T> root) {
        if(!this.isBalanced(root)) {
            int difference = this.height(root.getRight()) - this.height(root.getLeft());
            if(difference > 1) {//We need to rotate left
                if(this.height(root.getRight().getRight()) > this.height(root.getRight().getLeft())) { //Only rotate left
                    root = rotateLeft(root);
                } else { //Double rotation
                    root.setRight(rotateRight(root.getRight()));
                    root = rotateLeft(root);
                }
            } else if (difference < -1) {//We need to rotate right
                if(this.height(root.getLeft().getLeft()) > this.height(root.getLeft().getRight())) { //Only rotate right
                    root = rotateRight(root);
                } else { //Double rotation
                    root.setLeft(rotateLeft(root.getLeft()));
                    root = rotateRight(root);
                }
            }
        }
        return root;
    }
}