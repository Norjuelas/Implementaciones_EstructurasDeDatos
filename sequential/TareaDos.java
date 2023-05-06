package sequential;

import java.util.Scanner;
import java.util.ArrayList;

public class TareaDos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String a = input;
        String[] arr1 = a.split(" ");
        String input2 = scanner.nextLine();
        String b = input2;
        String[] arr2 = b.split(" ");

        int[] lista1 = new int[arr1.length];
        int[] lista2 = new int[arr2.length];

        ArrayList<Integer> uno = new ArrayList<>();
        ArrayList<Integer> dos = new ArrayList<>();

        for (int i = 0; i < lista1.length; i++) {
            lista1[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < lista2.length; i++) {
                lista2[lista2.length-1-i] = Integer.parseInt(arr2[i]);
        }
        for (int i = 0; i < lista1.length; i++) {
            if (lista1[i] != lista2[i]) {
                uno.add(lista1[i]);
                dos.add(lista2[i]);
            }
        }

        for (int i = 0; i < uno.size(); i++) {
            System.out.print(uno.get(i) + " ");
        }
        System.out.print("\n");

        for (int i = 0; i < dos.size(); i++) {
            System.out.print(dos.get(dos.size()-1-i) + " ");
        }
scanner.close();
    }
}