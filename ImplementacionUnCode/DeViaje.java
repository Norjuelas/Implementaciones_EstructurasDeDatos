package ImplementacionUnCode;
import util.TreeNode;
import nonSequential.*;
import java.util.ArrayList;
import java.util.Scanner;



class Main {
    public static void main(String[] args) {
        String[] linea = {"Mongui", "Sachica", "Tinjaca", "Combita", "Chiquiza", "Sutamarchan",
                "Tibasosa", "Toca", "Guican", "Chivata", "Topaga", "Soraca", "Gameza", "Guayata",
                "Raquira", "Nobsa", "Tenza", "Aquitania"};
        Scanner sc = new Scanner(System.in);
        String[] puntos = sc.nextLine().split(" ");
        AvlBinarySearchTree<String> arbol = new AvlBinarySearchTree<>();
        for (String s : linea) {
            arbol.insert(s);
        }
        arbol.inOrder();
        int i = construirCamino(arbol.getRoot(), puntos[0], puntos[1]).size();
        System.out.println(i+1);
    }
    public static int construirCamino(TreeNode<String> root, String inicio, String fin) {
        TreeNode<String> menorAncestroComun = menorAncestroComun(root, new TreeNode<>(inicio), new TreeNode<>(fin));
        ArrayList<String> camino = new ArrayList<>();
        if (menorAncestroComun == null) {
            return null;
        }
        TreeNode<String> aux = menorAncestroComun;
        while (!(aux.getKey().equals(fin))) {
            camino.add(aux.getKey());
            aux = aux.getKey().compareTo(fin) < 0 ? aux.getRight() : aux.getLeft();
        }
        TreeNode<String> aux2 = menorAncestroComun;
        while (!(aux2.getKey().equals(inicio))) {
            camino.add(aux2.getKey());
            aux2 = aux2.getKey().compareTo(inicio) < 0 ? aux2.getRight() : aux2.getLeft();
        }
        int suma;
        for(int i=0;i<=camino.size();i++){
            suma=+camino.get(i);
        }
        return suma;
    }
    public static TreeNode<String> menorAncestroComun(TreeNode<String> root, TreeNode<String> nodo1, TreeNode<String> nodo2) {
        if(root==null)
            return null;

        if(root.getKey().equals(nodo1.getKey()) || root.getKey().equals(nodo2.getKey()))
            return root;

        TreeNode<String> nodo3 = menorAncestroComun(root.getLeft(), nodo1, nodo2);
        TreeNode<String> nodo4 = menorAncestroComun(root.getRight(), nodo1, nodo2);

        if(nodo3!=null&&nodo4!=null){
            return root;
        }else if(nodo3==null&&nodo4==null){
            return null;
        }else{
            return nodo3==null?nodo4:nodo3;
        }

        public int sumTree(TreeNode root,int inicio, int fin) {
            TreeNode menorAncestroComun = menorAncestroComun(root, new TreeNode(inicio), new TreeNode(fin));
            ArrayList<Integer> camino = new ArrayList<>();
            if (menorAncestroComun == null) {
                return 0;
            }
            TreeNode<Integer> aux = menorAncestroComun;
            while (!(aux.getKey().equals(fin))) {
                camino.add(aux.getKey());
                aux = aux.getKey().compareTo(fin) < 0 ? aux.getRight() : aux.getLeft();
            }
            TreeNode<Integer> aux2 = menorAncestroComun;
            while (!(aux2.getKey().equals(inicio))) {
                camino.add(aux2.getKey());
                aux2 = aux2.getKey().compareTo(inicio) < 0 ? aux2.getRight() : aux2.getLeft();
            }
            int suma;
            for(int i=0;i<=camino.size();i++){
                suma=+camino.get(i);
            }
            return suma;
        }

        public TreeNode<Integer> menorAncestroComun(TreeNode<Integer> root, TreeNode<Integer> nodo1, TreeNode<Integer> nodo2) {
            if(root==null)
                return null;

            if(root.getKey().equals(nodo1.getKey()) || root.getKey().equals(nodo2.getKey()))
                return root;

            TreeNode<Integer> nodo3 = menorAncestroComun(root.getLeft(), nodo1, nodo2);
            TreeNode<Integer> nodo4 = menorAncestroComun(root.getRight(), nodo1, nodo2);

            if(nodo3!=null&&nodo4!=null){
                return root;
            }else if(nodo3==null&&nodo4==null){
                return null;
            }else{
                return nodo3==null?nodo4:nodo3;
            }
        }
        isEvenOddTree(TreeNode root) {
            if(root == null) return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer last = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (level % 2 == 0) {
                        if (node.getValue() % 2 == 0 || (last != null && node.getValue() <= last)) {
                            return false;
                        }
                    }
                    else {
                        if (node.getValue() % 2 != 0 || (last != null && node.getValue() >= last)) {
                       …


                            public boolean carPooling(CarPooling carPooling) {
                                Arrays.sort(carPooling.getTrips(), (a, b) -> a[1] - b[1]);
                                PriorityQueue<int[]> ongoingTrips = new PriorityQueue<>((a, b) -> a[2] - b[2]);
                                for (int[] trip : carPooling.getTrips()) {
                                    while (!ongoingTrips.isEmpty() && ongoingTrips.peek()[2] <= trip[1]) {
                                        carPooling.setSeats(carPooling.getSeats() + ongoingTrips.poll()[0]);
                                    }
                                    if (trip[0] > carPooling.getSeats()) {
                                        return false;
                                    }
                                    carPooling.setSeats(carPooling.getSeats() - trip[0]);
                                    ongoingTrips.offer(trip);
                                }
                                return true;
                            }
    }


