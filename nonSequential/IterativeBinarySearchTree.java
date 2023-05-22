package nonSequential;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class IterativeBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    protected TreeNode<T> root;


    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
    public IterativeBinarySearchTree(T data) {
        this.root = new TreeNode<>(data);
    }

    public IterativeBinarySearchTree() {
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
        this.delete(this.root, data);
    }



    @Override
    public void inOrder() {
        this.inOrder(this.root);
    }

    @Override
    public void preOrder() {
        if (root == null) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            System.out.print(current.getKey() + " ");

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }

    @Override
    public void postOrder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        TreeNode<T> prev = null;

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.peek();

            // Si el nodo actual no tiene hijos o los hijos han sido procesados
            if ((current.getLeft() == null && current.getRight() == null) ||
                    (prev != null && (prev == current.getLeft() || prev == current.getRight()))) {
                System.out.print(current.getKey() + " ");
                stack.pop();
                prev = current;
            } else {
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
            }
        }
    }


    @Override
    public int height() {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode<T> current = queue.poll();

                if (current.getLeft() != null) {
                    queue.offer(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.offer(current.getRight());
                }
            }

            height++;
        }

        return height;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }

        int size = 0;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            size++;

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        return size;
    }



    @Override
    public T minValue() {
        if (root == null) {
            throw new Error("Exception message");
        }

        TreeNode<T> current = root;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current.getKey();
    }

    @Override
    public T maxValue() {
        if (root == null) {
            throw new Error("BST is empty");
        }

        TreeNode<T> current = root;

        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getKey();
    }

    @Override
    public boolean isBalanced() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBalanced'" );
    }

    @Override
    public void balance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'balance'" );
    }
    // util--------------------------------------------------------------------------------------------
    // compareTo() 0 si son iguales, positivo si el elemento del cuerpo izquiero es
    // mayor que el del derecho

    private T search(TreeNode<T> root, T data) {
        TreeNode<T> temporal = root;
        while (temporal != null) {
            if (temporal.getKey().compareTo(data) == 0) {
                return temporal.getKey();
            } else if (temporal.getKey().compareTo(data) > 0) {
                temporal = temporal.getLeft();
            } else {
                temporal = temporal.getRight();
            }
        }
        return null;
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        TreeNode<T> nuevoNodo = new TreeNode<>(data);
        if (root == null) return root = nuevoNodo;
        TreeNode<T> temporal = root;
        while (true) {
            if (data.compareTo(temporal.getKey()) < 0) { // si el valor a insertar es menor que el valor actual en el nodo
                if (temporal.getLeft() == null) { // si el hijo izquierdo es nulo, insertar el nuevo nodo aqui
                    temporal.setLeft(nuevoNodo);
                    return root;
                } else { // si el hijo izquierdo no es nulo, seguir moviéndose hacia la izquierda del árbol
                    temporal = temporal.getLeft();
                }
            } else if (data.compareTo(temporal.getKey()) > 0) { // si el valor a insertar es mayor que el valor actual en el nodo
                if (temporal.getRight() == null) { // si el hijo derecho es nulo, insertar el nuevo nodo aquí
                    temporal.setRight(nuevoNodo);
                    return root;
                } else { // si el hijo derecho no es nulo, seguir moviéndose hacia la derecha del árbol
                    temporal = temporal.getRight();
                }
            } else { // si el valor a insertar ya existe en el árbol, no hacer nada
                return root;
            }
        }
    }

    private void inOrder(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> temporal = root;
        while (temporal != null || !stack.isEmpty()) {
            // moverse hacia el nodo más a la izquierda del árbol
            while (temporal != null) {
                stack.push(temporal);
                temporal = temporal.getLeft();
            }

            // procesar el nodo actual (el más a la izquierda del árbol)
            temporal = stack.pop();
            System.out.print(temporal.getKey() + " " );

            // moverse hacia el hijo derecho del nodo actual
            temporal = temporal.getRight();
        }
    }
    private TreeNode<T> getSuccessor(TreeNode<T> node) {
        TreeNode<T>  parent = node;
        TreeNode<T>  successor = node;
        TreeNode<T>  current = node.getRight(); // moverse hacia el hijo derecho del nodo actual

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeft(); // moverse hacia el hijo izquierdo del nodo actual
        }

        if (successor != node.getRight()) { // si el sucesor no es el hijo derecho del nodo actual
            parent.setLeft(successor.getRight()); // conectar el hijo derecho del sucesor al padre del sucesor
            successor.setRight(node.getRight()); // conectar el hijo derecho del nodo actual al sucesor
        }
        return successor;
    }

    private TreeNode<T> delete(TreeNode<T> root, T data) {
        if (root == null) { // si el árbol está vacío, devolver null
            return root;
        }
        TreeNode<T> padre = null;
        TreeNode<T> temporal = root; // comenzar por la raíz del árbol

        while (temporal != null) {
            if (data.compareTo(temporal.getKey()) < 0) { // si el valor a eliminar es menor que el valor actual en el nodo
                padre = temporal;
                temporal = temporal.getLeft(); // moverse hacia el hijo izquierdo del nodo actual
            } else if (data.compareTo(temporal.getKey()) > 0) { // si el valor a eliminar es mayor que el valor actual en el nodo
                padre = temporal;
                temporal = temporal.getRight(); // moverse hacia el hijo derecho del nodo actual
            } else { // si el valor a eliminar coincide con el valor actual en el nodo
                if (temporal.getLeft() == null && temporal.getRight() == null) { // si el nodo actual no tiene hijos
                    if (temporal == root) { // si el nodo actual es la raíz del árbol
                        root = null;
                    } else if (temporal == padre.getLeft()) { // si el nodo actual es el hijo izquierdo del padre
                        padre.setLeft(null);
                    } else { // si el nodo actual es el hijo derecho del padre
                        padre.setRight(null);
                    }
                } else if (temporal.getLeft() == null) { // si el nodo actual tiene un hijo derecho
                    if (temporal == root) { // si el nodo actual es la raíz del árbol
                        root = temporal.getRight();
                    } else if (temporal == padre.getLeft()) { // si el nodo actual es el hijo izquierdo del padre
                        padre.setLeft(temporal.getRight());
                    } else { // si el nodo actual es el hijo derecho del padre
                        padre.setRight(temporal.getRight());
                    }
                } else if (temporal.getRight() == null) { // si el nodo actual tiene un hijo izquierdo
                    if (temporal == root) { // si el nodo actual es la raíz del árbol
                        root = temporal.getLeft();
                    } else if (temporal == padre.getLeft()) { // si el nodo actual es el hijo izquierdo del padre
                        padre.setLeft( temporal.getLeft());
                    } else { // si el nodo actual es el hijo derecho del padre
                        padre.setRight(temporal.getLeft());
                    }
                } else { // si el nodo actual tiene dos hijos
                    TreeNode<T> sucesor = getSuccessor(temporal); // encontrar el sucesor del nodo actual
                    if (temporal == root) { // si el nodo actual es la raíz del árbol
                        root = sucesor;
                    } else if (temporal == padre.getLeft()) { // si el nodo actual es el hijo izquierdo del padre
                        padre.setLeft(sucesor);
                    } else { // si el nodo actual es el hijo derecho del padre
                        padre.setRight(sucesor);
                    }
                    sucesor.setLeft(temporal.getLeft());
                }
                return root;
            }
        }
        return root;
    }
}
