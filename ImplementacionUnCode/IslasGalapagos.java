import java.util.*;

public class Main {

    private static void inorder(int[] tree, int i, List<Integer> CaminoATomar) {
        if (i >= tree.length || tree[i] == -1) {
            return;
        }
        inorder(tree, 2 * i + 1, CaminoATomar);
        CaminoATomar.add(tree[i]);
        inorder(tree, 2 * i + 2, CaminoATomar);
    }

    private static void preorder(int[] tree, int i, List<Integer> CaminoATomar) {
        if (i >= tree.length || tree[i] == -1) {
            return;
        }
        CaminoATomar.add(tree[i]);
        preorder(tree, 2 * i + 1, CaminoATomar);
        preorder(tree, 2 * i + 2, CaminoATomar);
    }

    private static void postorder(int[] Tree, int i, List<Integer> CaminoATomar) {
        if (i >= Tree.length || Tree[i] == -1) {
            return;
        }
        postorder(Tree, 2 * i + 1, CaminoATomar);
        postorder(Tree, 2 * i + 2, CaminoATomar);
        CaminoATomar.add(Tree[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] insectos = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = Integer.parseInt(scanner.nextLine());

        List<Integer> inorderRecorrido = new ArrayList<>();
        List<Integer> preorderRecorrido = new ArrayList<>();
        List<Integer> postorderRecorrido = new ArrayList<>();

        inorder(insectos, 0, inorderRecorrido);
        preorder(insectos, 0, preorderRecorrido);
        postorder(insectos, 0, postorderRecorrido);

        int maxInsectosInorder = inorderRecorrido.stream().limit(a).mapToInt(Integer::intValue).sum();
        int maxInsectosPreorder = preorderRecorrido.stream().limit(a).mapToInt(Integer::intValue).sum();
        int maxInsectosPostorder = postorderRecorrido.stream().limit(a).mapToInt(Integer::intValue).sum();

        String recorridoSeleccionado = "";
        int maxInsectos = 0;

        if (maxInsectosPreorder >= maxInsectosInorder && maxInsectosPreorder >= maxInsectosPostorder) {
            recorridoSeleccionado = "Preorder";
            maxInsectos = maxInsectosPreorder;
        } else if (maxInsectosInorder >= maxInsectosPreorder && maxInsectosInorder >= maxInsectosPostorder) {
            recorridoSeleccionado = "Inorder";
            maxInsectos = maxInsectosInorder;
        } else {
            recorridoSeleccionado = "Postorder";
            maxInsectos = maxInsectosPostorder;
        }

        System.out.print(recorridoSeleccionado + " " + maxInsectos);
    }
    public int sumTree(TreeNode root,int inicio, int fin){
        ArrayList<Integer> numeros=new Arraylist<>();
        numeros = sumando(root);
        int suma=0;
        for(int i=0;i<=numeros.size();i++){
            if(i<fin && i>inicio) {
                int numero=camino.get(i);
                suma=+numero;
            }

        }
        return suma;
    }
}